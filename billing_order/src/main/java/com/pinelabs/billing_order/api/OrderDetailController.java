package com.pinelabs.billing_order.api;

import com.pinelabs.billing_order.model.OrderDetails;
import com.pinelabs.billing_order.service.OrderDetailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/")
    @ApiOperation(value = "Add order", notes = "Add order")
    public ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {

        OrderDetails orderDetails1 = orderDetailService.addOrderDetails(orderDetails);
        return ResponseEntity.ok(orderDetails1);
    }

    @GetMapping("/")
    @ApiOperation(value = "Get orders", notes = "Get list of all orders")
    public ResponseEntity<List<OrderDetails>> getOrderList() {
        List<OrderDetails> orderDetails = orderDetailService.getOrderList();
        return ResponseEntity.ok(orderDetails);
    }
}
