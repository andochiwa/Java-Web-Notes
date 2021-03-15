package com.me.test;

import com.me.pojo.Cart;
import com.me.pojo.CartItem;
import com.me.service.OrderService;
import com.me.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构", 1, new BigDecimal(100), new BigDecimal(2000)));

        OrderService orderService = new OrderServiceImpl();

        System.out.println(orderService.createOrder(cart, 1));
    }
}