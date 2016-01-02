package com.bdc.service;

import com.bdc.model.User;

/**
 * Created by Administrator on 2015/12/27.
 */
public interface UserService extends GenericService<User, Integer> {
    void signup(User user);
    User login(User user);
}
