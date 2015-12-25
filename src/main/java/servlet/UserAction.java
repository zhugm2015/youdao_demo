package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import model.Word;
import org.apache.ibatis.session.SqlSession;
import util.DB;
import util.SqlSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
        if (action.equals("check")) {
            check(req,resp);
        }

    }
    //检测是否有相同的用户名存在
    private void check(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(false);
        User user = sqlSession.selectOne("user.check",new User(null,req.getParameter("username"),null));
        sqlSession.close();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,Boolean> map = new HashMap<>();
        if (user!=null) {
            map.put("isUsernameExist",true);
        } else {
            map.put("isUsernameExist",false);
        }
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().print(objectMapper.writeValueAsString(map));
    }

    //退出
    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().invalidate();
        resp.sendRedirect("default.jsp");
    }

    //登录
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username=req.getParameter("username");  //req.getParameter（）获取用户填写的表单参数
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

       /* SqlSession sqlSession = SqlSessionUtil.getSqlSession(false);
        User user = sqlSession.selectOne("user.login", new User(null, req.getParameter("username"), req.getParameter("password")));
        sqlSession.close();
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("word?action=query");
        } else {
            req.setAttribute("message", "error.");
            req.getRequestDispatcher("default.jsp").forward(req, resp);
        }*/
    }

    //注册
    private void signup(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession(true);
        sqlSession.insert("user.signup", new User(null, req.getParameter("username"), req.getParameter("password")));
       // sqlSession.commit();
        sqlSession.close();
        resp.sendRedirect("default.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
