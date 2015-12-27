package com.bdc.dao.impl;

import com.bdc.dao.UserDao;
import com.bdc.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2015/12/27.
 */
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public void add(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        sqlSession.insert("user.signup",user);
        sqlSession.close();
    }
}
