package com.bdc.dao;

import com.bdc.model.User;

/**
 * Created by Administrator on 2015/12/27.
 */
//定义UserDao接口继承接口GenericDao，即继承接口里的所有方法 add，remove，queryOne
//4.DAO 放通用数据库方法
public interface UserDao extends GenericDao<User,Integer> {

}
