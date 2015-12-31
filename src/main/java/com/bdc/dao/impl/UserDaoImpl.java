package com.bdc.dao.impl;

import com.bdc.dao.UserDao;
import com.bdc.model.User;
import org.springframework.stereotype.Repository;


/**
 * Created by Administrator on 2015/12/27.
 */
//继承GenericDaoImpl，实现接口UserDao
@Repository  //注册成为容器里的一个bean
public class UserDaoImpl extends GenericDaoImpl<User,Integer> implements UserDao {

}
