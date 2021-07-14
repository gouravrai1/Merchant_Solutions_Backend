package com.pinelabs.billing_order.service.impl;

import com.pinelabs.billing_order.model.Order;
import com.pinelabs.billing_order.repository.OrderRepository;
import com.pinelabs.billing_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    WebClient webClient;

    private static final String BASE_URL_STORE = "http://localhost:8082/api/v1/store/";
    private static final String BASE_URL_USER = "http://localhost:8081/api/v1/user/";


    @Override
    public List<Order> getOrderList() {
        List<Order> order = orderRepository.findAll();
        return order;
    }

    @Override
    public Order addOrder(Order order) {
        Order order1 = getStoreNameById(order.getStoreId());

        order.setStoreId(order1.getStoreId());
        order.setStoreName(order1.getStoreName());

        order1 = getUserNameById(order.getUserId());
        if (order1.getIsCustomer()) {
            order.setIsCustomer(order1.getIsCustomer());
            order.setUserId(order1.getUserId());
            order.setUserName(order1.getUserName());

            order.setItemsCount(0);
            order.setOrderAmount(0.0);
            orderRepository.save(order);
            return order;
        }
        return null;
    }


    public Order getStoreNameById(Long storeId) {
        return webClient
                .get()
                .uri(BASE_URL_STORE + storeId)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(Order.class)
                .block();
    }

    public Order getUserNameById(Long userId) {
        return webClient
                .get()
                .uri(BASE_URL_USER + userId)
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(Order.class)
                .block();
    }
}
