package com.foreground.service.serviceImpl;

import com.foreground.dao.OrderDao;
import com.foreground.entity.Order;
import com.foreground.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Integer addSimpleOrder(Order order) {
        return orderDao.addSimpleOrder(order);
    }

    @Override
    public List<Order> queryAllOrderByUserId(Order order) {
        return orderDao.queryAllOrderByUserId(order);
    }

    @Override
    public Integer delSimpleOrderByUserId(Order order) {
        return orderDao.delSimpleOrderByUserId(order);
    }
}
