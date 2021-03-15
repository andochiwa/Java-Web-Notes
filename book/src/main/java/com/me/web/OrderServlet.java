package com.me.web;

import com.me.pojo.Cart;
import com.me.pojo.User;
import com.me.service.OrderService;
import com.me.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User loginUser = (User) request.getSession().getAttribute("user");
        System.out.println(loginUser);
        int id = 1;
        String orderId = null;
        orderId = orderService.createOrder(cart, id);
//        request.setAttribute("orderId", orderId);
        request.getSession().setAttribute("orderId", orderId);

        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
