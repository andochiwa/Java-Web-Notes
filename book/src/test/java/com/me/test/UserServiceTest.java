package com.me.test;

import com.me.pojo.User;
import com.me.service.UserService;
import com.me.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService us = new UserServiceImpl();

    @Test
    public void registUser() {
        us.registUser(new User(null, "abcd", "1234", "my@gmail.com"));
        us.registUser(new User(null, "abc124", "6666", "my@gmail.com"));

    }

    @Test
    public void login() {
        System.out.println(us.login(new User(null, "admin", "admin", null)));
    }

    @Test
    public void existsUserName() {
        if(us.existsUserName("admin")) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}