package com.jiker.service.frontend.service.impl;

import com.jiker.service.frontend.domain.Item;
import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;
import com.jiker.service.frontend.service.OrderService;
import com.jiker.service.frontend.service.impl.local.OrderLocalService;
import com.jiker.service.infrastructure.exception.ServiceException;
import com.jiker.service.middle.domain.Account;
import com.jiker.service.middle.domain.Product;
import com.jiker.service.middle.service.AccountService;
import com.jiker.service.middle.service.ProductService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DubboService(version = "${frontend.service.version}")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderLocalService orderLocalService;

    @DubboReference(version = "${middle.service.version}")
    private AccountService accountService;

    @DubboReference(version = "${middle.service.version}")
    private ProductService productService;

    @Override
    public Order addOrder(Order order) {

        //根据AccountId调用远程Dubbo服务来获取Account信息
        Account account = accountService.getAccountById(order.getAccountId());
        if(account == null) {
            throw new ServiceException("The account for order is not existed");
        }

        for(Item item : order.getItems()) {
            //根据ProductCode调用远程Dubbo服务来获取Product信息
            Product product = productService.getProductByProductCode(item.getProductCode());
            if(product == null) {
                throw new ServiceException("The product for order is not existed");
            }
        }

        orderLocalService.addOrder(order);

        return order;
    }

    @Override
    public void confirmOrder(Order order) {
        order.setStatus(OrderStatus.CONFIRMED);
        orderLocalService.updateOrderStatus(order);
    }

    @Override
    public void cancelOrder(Order order) {
        order.setStatus(OrderStatus.CANCELLED);
        orderLocalService.updateOrderStatus(order);
    }

    @Override
    public void shipOrder(Order order) {
        order.setStatus(OrderStatus.SHIPPED);
        orderLocalService.updateOrderStatus(order);
    }

    @Override
    public void finishOrder(Order order) {
        order.setStatus(OrderStatus.FINISHED);
        orderLocalService.updateOrderStatus(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderLocalService.getOrderById(id);
    }

    @Override
    public List<Order> getOrdersByAccountId(Long accountId) {
        return orderLocalService.getOrdersByAccountId(accountId);
    }

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderLocalService.getOrdersByStatus(status);
    }
}
