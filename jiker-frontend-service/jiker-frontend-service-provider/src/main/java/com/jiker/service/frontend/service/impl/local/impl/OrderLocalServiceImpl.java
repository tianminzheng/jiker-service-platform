package com.jiker.service.frontend.service.impl.local.impl;

import com.jiker.service.frontend.domain.Item;
import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;
import com.jiker.service.frontend.repository.ItemRepository;
import com.jiker.service.frontend.repository.OrderRepository;
import com.jiker.service.frontend.service.impl.local.OrderLocalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLocalServiceImpl implements OrderLocalService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void addOrder(Order order) {

        Order savedOrder = orderRepository.save(order);

        for(Item item : order.getItems()) {
            item.setOrderId(savedOrder.getId());
            itemRepository.save(item);
        }
    }

    @Override
    public void updateOrderStatus(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {

        Order order = orderRepository.getOne(id);

        List<Item> items = itemRepository.getItemsByOrderId(id);

        order.setItems(items);

        return order;
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {

        List<Order> orders = orderRepository.getOrdersByStatus(status);

        fillOrderItems(orders);

        return orders;
    }

    @Override
    public List<Order> getOrdersByAccountId(Long accountId) {
        List<Order> orders = orderRepository.getOrdersByAccountId(accountId);

        fillOrderItems(orders);

        return orders;
    }

    private List<Order> fillOrderItems(List<Order> orders) {
        for(Order order : orders) {
            List<Item> items = itemRepository.getItemsByOrderId(order.getId());

            order.setItems(items);
        }

        return orders;
    }
}
