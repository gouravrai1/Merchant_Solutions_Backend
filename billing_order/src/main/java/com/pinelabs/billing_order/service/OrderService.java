package com.pinelabs.billing_order.service;

import com.pinelabs.billing_order.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList();

    Order addOrder(Order order);
}
