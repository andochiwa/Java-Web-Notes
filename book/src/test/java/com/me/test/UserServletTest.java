package com.me.test;

import java.lang.reflect.Method;

public class UserServletTest {

    public void login() {
        System.out.println("这是login方法");
    }

    public void regist() {
        System.out.println("这是regist方法");
    }

    public void updateUser() {
        System.out.println("这是updateUser方法");
    }

    public void updatePassword() {
        System.out.println("这是updatePassword方法");
    }
    public static void main(String[] args){
      String action = "login";

        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            method.invoke(new UserServletTest());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
