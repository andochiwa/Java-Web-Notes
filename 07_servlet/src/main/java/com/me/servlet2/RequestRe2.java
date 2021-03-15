package com.me.servlet2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RequestRe2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String username = request.getParameter("username");
        System.out.println("servlet2: " + username);

        // 查看柜台1是否有盖章
        Object key = request.getAttribute("key");
        System.out.println("servlet1Request?: " + key);

        // 处理自己的业务
        System.out.println("servlet2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
