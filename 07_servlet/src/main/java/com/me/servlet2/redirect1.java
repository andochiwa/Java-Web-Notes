package com.me.servlet2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class redirect1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("red1");
        // 设置响应状态码302表示重定向
//        response.setStatus(302);
        // 设置响应头，说明新的地址在哪里
//        response.setHeader("Location", "http://localhost:8080/07_servlet/re2");
        //推荐使用
        response.sendRedirect("http://localhost:8080/07_servlet/re2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
