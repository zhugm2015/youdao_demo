package com.bdc.dao;

import java.io.Serializable;

/**
 * Created by BH00350 on 2015/12/29.
 */

    //定义泛型接口
public interface GenericDao<T extends Serializable,ID extends Serializable> {
    void add(T t);        //注册一个用户
    void remove(ID id);
    T queryOne(T t);
}
