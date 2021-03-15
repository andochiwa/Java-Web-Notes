package com.me.dao.impl;

import com.me.dao.OrderItemDao;
import com.me.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderitem) {
        String sql = "insert into t_order_item(name, count, price, total_price, order_id) values(?,?,?,?,?)";
        return update(sql, orderitem.getName(), orderitem.getCount(), orderitem.getPrice(), orderitem.getTotalPrice(), orderitem.getOrderId());
    }
}
