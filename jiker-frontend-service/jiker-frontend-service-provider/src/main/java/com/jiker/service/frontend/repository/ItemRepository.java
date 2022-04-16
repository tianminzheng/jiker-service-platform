package com.jiker.service.frontend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiker.service.frontend.domain.Item;
import com.jiker.service.frontend.domain.Order;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	//根据订单编号获取Item列表
    List<Item> getItemsByOrderId(Long orderId);
}
