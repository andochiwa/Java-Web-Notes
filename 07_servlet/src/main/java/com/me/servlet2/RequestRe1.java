package com.me.servlet2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RequestRe1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数（办事的材料）查看
        String username = request.getParameter("username");
        System.out.println("servlet1: " + username);

        // 给材料盖一个章，并传递到RequestRe2
        request.setAttribute("key", "servlet1Request");

        // 问路
        // 请求转发必须要以斜杆打头
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/retwo");

        // 走向servlet2
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
