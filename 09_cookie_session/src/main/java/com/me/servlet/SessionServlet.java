package com.me.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("key1", "value1");
    }

    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object attribute = request.getSession().getAttribute("key1");
        response.getWriter().write("从Session中获取出的key1的数据是:" + attribute);
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("session的默认超时时长为:" + maxInactiveInterval);
    }

    protected void life3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setMaxInactiveInterval(3);
        response.getWriter().write("当前session已设置为3秒后超时");
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        response.getWriter().write("session已经被销毁");
    }

    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean isNew = session.isNew();

        String id = session.getId();

        response.getWriter().write("得到的session的id是:" + id + "<br/>");
        response.getWriter().write("这个session是否是新创建的:" + isNew + "<br/>");

    }

}
