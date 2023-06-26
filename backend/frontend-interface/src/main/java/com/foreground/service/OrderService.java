package com.foreground.service;

import com.foreground.entity.Order;

import java.util.List;

public interface OrderService {
    public Integer addSimpleOrder(Order order);

    public List<Order> queryAllOrderByUserId(Order order);

    public Integer delSimpleOrderByUserId(Order order);
}
