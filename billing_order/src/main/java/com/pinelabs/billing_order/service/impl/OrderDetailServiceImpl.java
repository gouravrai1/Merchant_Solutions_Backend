package com.pinelabs.billing_order.service.impl;

import com.pinelabs.billing_order.model.Order;
import com.pinelabs.billing_order.model.OrderDetails;
import com.pinelabs.billing_order.repository.OrderDetailRepository;
import com.pinelabs.billing_order.repository.OrderRepository;
import com.pinelabs.billing_order.service.OrderDetailService;
import com.pinelabs.billing_order.utility.OrderStatus;
import com.pinelabs.billing_order.utility.UnitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDetails> getOrderList() {
        List<OrderDetails> orderDetails = orderDetailRepository.findAll();
        return orderDetails;
    }

    @Override
    public OrderDetails addOrderDetails(OrderDetails orderDetails) {
        Optional<Order> order = orderRepository.findById(orderDetails.getOrderId());
        order.get().setOrderStatus(OrderStatus.SAVED);
        order.get().setItemsCount(order.get().getItemsCount() + 1);
        if (orderDetails.getUnitType() == UnitType.KG) {
            orderDetails.setTotalAmount(orderDetails.getUnitSellingPrice() * orderDetails.getItemQuantity());
            order.get().setOrderAmount(order.get().getOrderAmount() + orderDetails.getTotalAmount());
        } else if (orderDetails.getUnitType() == UnitType.GM) {
            Double amount = (orderDetails.getItemQuantity() / 1000.0) * orderDetails.getUnitSellingPrice();
            orderDetails.setTotalAmount(amount);
            order.get().setOrderAmount(order.get().getOrderAmount() + orderDetails.getTotalAmount());

        } else if (orderDetails.getUnitType() == UnitType.LTR) {
            orderDetails.setTotalAmount(orderDetails.getUnitSellingPrice() * orderDetails.getItemQuantity());
            order.get().setOrderAmount(order.get().getOrderAmount() + orderDetails.getTotalAmount());
        } else {
            orderDetails.setTotalAmount(orderDetails.getUnitSellingPrice() * orderDetails.getItemQuantity());
            order.get().setOrderAmount(order.get().getOrderAmount() + orderDetails.getTotalAmount());
        }
        orderDetailRepository.save(orderDetails);
        return orderDetails;
    }
}