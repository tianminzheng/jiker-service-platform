package com.jiker.service.frontend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	//根据状态获取订单列表
    List<Order> getOrdersByStatus(OrderStatus status);

    //根据账户编号获取订单列表
    List<Order> getOrdersByAccountId(Long accountId);
}
