package com.me.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getRequestURI 获取请求的资源路径
        System.out.println("URI -> " + req.getRequestURI());
        // getRequestURL 获取请求的统一资源定位符
        System.out.println("URL -> " + req.getRequestURL());
        // getRemoteHost() 获取客户端的ip地址
        System.out.println("IP -> " + req.getRemoteHost());
        // getHeader()
        System.out.println("User-Agent -> " + req.getHeader("User-Agent"));
        // getMethod()
        System.out.println("requestPattern -> " + req.getMethod());

    }
}
