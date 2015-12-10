package servlet;

import util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by BH00350 on 2015/12/7.
 */
@WebServlet("/user")
public class UserAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");     //req.getParameter（）获取用户填写的表单参数
        if (action.equals("signup")) {
            signup(req, resp);                   //alt + enter创建方法
        }
        if (action.equals("login")) {
            login(req, resp);
        }
        if (action.equals("logout")) {
            logout(req,resp);
        }

    }

    //退出
    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("default.jsp");
    }

    //登录
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;     // resultSet结果集
        try {
            preparedStatement=DB.getConnection().prepareStatement("SELECT * FROM user WHERE username=? and password=?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()) {
                req.getSession().setAttribute("username", username);
                //resp.sendRedirect("index.jsp");     //重定向到index
                resp.sendRedirect("word?action=query");
            } else {
                req.setAttribute("message","error.");
                req.getRequestDispatcher("default.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(resultSet,preparedStatement);
        }
    }

    //注册
    private void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");  //req.getParameter（）获取用户填写的表单参数
        String password=req.getParameter("password");
        PreparedStatement preparedStatement=null;         // statement用来执行SQL语句
        try {
            preparedStatement= DB.getConnection().prepareStatement("INSERT INTO user VALUES (NULL,?,?)");  //连接数据库
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
            resp.sendRedirect("default.jsp");           //抛异常
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(null,preparedStatement);       //关闭数据库
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
