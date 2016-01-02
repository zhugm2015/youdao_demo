package com.bdc.service.impl;

import com.bdc.dao.GenericDao;
import com.bdc.service.GenericService;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/27.
 */
public abstract class GenericServiceImpl<T extends Serializable, ID extends Serializable> implements GenericService<T, ID> {

    protected GenericDao<T, ID> genericDao;

    protected abstract void setGenericDao(GenericDao<T, ID> genericDao);

    @Override
    public void add(T t) {
        genericDao.add(t);
    }

    @Override
    public void remove(ID id) {
        genericDao.remove(id);
    }

    @Override
    public T queryOne(T t) {
        return genericDao.queryOne(t);
    }
}
