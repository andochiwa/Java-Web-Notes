package com.me.service;

import com.me.pojo.Cart;

public interface OrderService {

    String createOrder(Cart cart, Integer id);

}
