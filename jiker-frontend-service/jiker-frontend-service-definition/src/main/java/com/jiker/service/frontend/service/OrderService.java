package com.jiker.service.frontend.service;

import java.util.List;

import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;

public interface OrderService {

	//下单
    Order addOrder(Order order);

    //确认订单
    void confirmOrder(Order order);

    //取消订单
    void cancelOrder(Order order);

    //订单发货
    void shipOrder(Order order);

    //结束订单
    void finishOrder(Order order);

    //根据Id获取订单详情
    Order getOrderById(Long id);

    //根据用户Id获取订单列表
    List<Order> getOrdersByAccountId(Long accountId);

    //根据状态获取订单列表
    List<Order> getOrdersByStatus(OrderStatus status);
}
