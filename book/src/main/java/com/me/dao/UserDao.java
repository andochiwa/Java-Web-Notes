package com.me.dao;

import com.me.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return 如果null说明没有这个用户
     */
    User queryUserByUserName(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果null说明没有这个用户
     */
    User queryUserByUserNameAndPassword(String username, String password);

    /**
     * 保存用户信息
     *
     * @param user
     * @return -1表示操作失败
     */
    int saveUser(User user);



}
