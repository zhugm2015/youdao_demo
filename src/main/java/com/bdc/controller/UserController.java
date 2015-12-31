package com.bdc.controller;

import com.bdc.model.User;
import com.bdc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by BH00350 on 2015/12/29.
 */
//2.Controller控制器
@Controller                          //注册成为容器里的一个bean
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;  //接口定义一个对象　　多态的应用

    @RequestMapping("/add")             //处理add模块所有请求
    private String add(User user) {
        userService.signup(user);
        return "default";
    }

    @RequestMapping("/login")
    private String login(User user){
        user = userService.login(user);
        if(user != null){
            getSession().setAttribute("user",user);
            return "index";
        }else {
            getRequest().setAttribute("message","invalid username or password.");
            return "default";
        }
    }

    @RequestMapping("/check")
    private @ResponseBody Map<String,Object> check(@RequestParam String username){
        User user = userService.queryOne(new User(null,username,null));
        Map<String,Object> map = new HashMap<>();
        if (user != null) {
            map.put("isUsernameExist", true);
        } else {
            map.put("isUsernameExist", false);
        }
        return map;
    }

    @RequestMapping("/logout")
    private String logout(){
        getSession().invalidate();
        return "default";
    }

}
