package com.jiker.service.frontend.service.impl.local;

import java.util.List;

import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;

public interface OrderLocalService {

	//添加订单
    void addOrder(Order order);

    //更新订单状态
    void updateOrderStatus(Order order);

    //根据Id获取订单信息
    Order getOrderById(Long id);

    //根据状态获取订单列表
    List<Order> getOrdersByStatus(OrderStatus status);

    //根据账户编号获取订单列表
    List<Order> getOrdersByAccountId(Long accountId);
}
