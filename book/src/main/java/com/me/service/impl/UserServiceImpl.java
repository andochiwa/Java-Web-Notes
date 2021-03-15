package com.me.service.impl;

import com.me.dao.UserDao;
import com.me.dao.impl.UserDaoImpl;
import com.me.pojo.User;
import com.me.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUserName(String username) {
        return userDao.queryUserByUserName(username) != null;
    }
}
