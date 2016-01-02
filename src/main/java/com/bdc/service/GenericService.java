package com.bdc.service;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/27.
 */
public interface GenericService<T extends Serializable, ID extends  Serializable> {
    void add(T t);
    void remove(ID id);
    T queryOne(T t);
}
