package com.me.service;

import com.me.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    void registUser(User user);

    /**
     * 登录
     * @param user
     * @return null说明登陆失败
     */
    User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return true表示用户名已存在
     */
    boolean existsUserName(String username);

}
