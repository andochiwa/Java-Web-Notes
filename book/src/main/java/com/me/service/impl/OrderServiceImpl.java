package com.me.service.impl;

import com.me.dao.BookDao;
import com.me.dao.OrderDao;
import com.me.dao.OrderItemDao;
import com.me.dao.impl.BookDaoImpl;
import com.me.dao.impl.OrderDaoImpl;
import com.me.dao.impl.OrderItemDaoImpl;
import com.me.pojo.Book;
import com.me.pojo.Cart;
import com.me.pojo.Order;
import com.me.pojo.OrderItem;
import com.me.service.OrderService;

import java.util.Date;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);

        orderDao.saveOrder(order);

        cart.getItems().forEach((k, v) -> {

            OrderItem orderItem = new OrderItem(null, v.getName(), v.getCount(), v.getPrice(), cart.getTotalPrice(), orderId);

            orderItemDao.saveOrderItem(orderItem);

            Book book = bookDao.queryBookById(v.getId());
            book.setSales(book.getSales() + v.getCount());
            book.setStock(book.getStock() - v.getCount());
            bookDao.updateBook(book);

        });

        cart.clear();

        return orderId;
    }
}
