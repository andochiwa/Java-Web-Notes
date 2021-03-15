package com.me.test;

import com.me.dao.UserDao;
import com.me.dao.impl.UserDaoImpl;
import com.me.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUserName() {
        if((userDao.queryUserByUserName("admi") == null)) {
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUserNameAndPassword() {
        System.out.println(userDao.queryUserByUserNameAndPassword("admin", "admin"));
        if((userDao.queryUserByUserNameAndPassword("admin", "admin")) == null) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "wzg168", "123456", "fwakl@qq.com")));
    }
}