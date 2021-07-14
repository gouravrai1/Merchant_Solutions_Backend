package com.pinelabs.billing_order.api;

import com.pinelabs.billing_order.model.Order;
import com.pinelabs.billing_order.repository.OrderRepository;
import com.pinelabs.billing_order.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    WebClient webClient;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    @ApiOperation(value = "Get orders", notes = "Get list of all orders")
    public ResponseEntity<List<Order>> getOrderList() {
        List<Order> order = orderService.getOrderList();
        return ResponseEntity.ok(order);
    }

    @PostMapping("/")
    @ApiOperation(value = "Add order", notes = "Add order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {

        Order generateOrderId = orderService.addOrder(order);
        return ResponseEntity.ok(generateOrderId);
    }
}