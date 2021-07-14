package com.pinelabs.billing_order.service;

import com.pinelabs.billing_order.model.OrderDetails;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetails> getOrderList();

    OrderDetails addOrderDetails(OrderDetails orderDetails);
}
