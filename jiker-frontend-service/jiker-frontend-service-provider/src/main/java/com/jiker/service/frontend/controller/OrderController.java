package com.jiker.service.frontend.controller;

import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;
import com.jiker.service.frontend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "")
    public Order addOrder(@RequestBody Order order) {

        return orderService.addOrder(order);
    }

    @GetMapping(value = "/{orderId}")
    public Order getOrderById(@PathVariable Long orderId) {

        return orderService.getOrderById(orderId);
    }

    @GetMapping(value = "/status/{orderStatus}")
    public List<Order> getOrderByStatus(@PathVariable OrderStatus orderStatus) {

        return orderService.getOrdersByStatus(orderStatus);
    }

}
