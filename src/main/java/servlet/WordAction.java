package servlet;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BH00350 on 2015/12/9.   添加EncodingFilter类，过滤器解决中文乱码问题
 */
@WebServlet(urlPatterns = "/word")
public class WordAction extends HttpServlet {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");  //req.getParameter（）获取用户填写的表单参数
        if (action.equals("add")) {
            add(req,resp);
        }
        if (action.equals("query")) {
            query(req, resp);
        }
        if (action.equals("search")) {
            search(req,resp);
        }
        if (action.equals("update")) {
            update(req,resp);
        }
        if (action.equals("delete")) {
            delete(req,resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //方式一：jdbc
        //方式二：mybatis
        SqlSession sqlSession=SqlSessionUtil.getSqlSession(true);
        sqlSession.delete("word.delete", getWord(req));
        //sqlSession.commit();
        sqlSession.close();
        resp.sendRedirect("word?action=query");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession=SqlSessionUtil.getSqlSession(true);
        sqlSession.update("word.update", getWord(req));
        //sqlSession.commit();
        sqlSession.close();
        resp.sendRedirect("word?action=query");
    }


    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession= SqlSessionUtil.getSqlSession(true);
        sqlSession.insert("word.add",getWord(req));
        sqlSession.commit();
        sqlSession.close();
        resp.sendRedirect("word?action=query");
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession=SqlSessionUtil.getSqlSession(false);
        req.getSession().setAttribute("word",sqlSession.selectOne("word.search",getWord(req)));
        //sqlSession.commit();
        sqlSession.close();
        resp.sendRedirect("edit.jsp");
    }

    /*  1/List中可以添加任何对象，包括自己定义的新的类。
        2、List是一个接口，不能实例化，需要实例化一个ArrayList或者LinkedList  List myList = new ArrayList();
        3、使用myList.add(任何对象);就可以进行添加了。4、取值的时候myList.get(索引);取出来的值都是Object，使用时需要类型转换。
        ArrayList就是传说中的动态数组：动态的增加和减少元素
        List 集合中的对象按照一定的顺序排放，里面的内容可以重复。List接口实现的类：ArrayList(实现动态数组)， Vector（实现动态数组） ，LinkedList（实现链表）， Stack（实现堆栈）*/
    private void query(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SqlSession sqlSession=SqlSessionUtil.getSqlSession(false);//查询可以不用commit
        req.getSession().setAttribute("words",sqlSession.selectList("word.query"));
        sqlSession.close();
        resp.sendRedirect("index.jsp");
    }

    private Word getWord(HttpServletRequest req) {
        Integer id = null;
        if (req.getParameter("id") != null) {
            id = Integer.parseInt(req.getParameter("id"));
        }
        return new Word(id, req.getParameter("english"), req.getParameter("chinese"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
