package com.jiker.service.frontend;

import org.junit.Assert;
import org.junit.Test;

import com.jiker.service.frontend.domain.Item;
import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class OrderTests {

    @Test
    public void testOrderTotalPrice() {

        Order order = buildOrder();

        Assert.assertTrue(order.getTotalPrice() == 400F);
    }

    private Order buildOrder() {

        Order order = new Order();
        order.setAccountId(1L);
        order.setStatus(OrderStatus.INITIALIZED);

        List<Item> items = new ArrayList<>();
        Item item1 = new Item();
        item1.setItemCount(1);
        item1.setProductCode("product_code1");
        item1.setProductName("product_name1");
        item1.setProductPrice(100F);
        items.add(item1);

        Item item2 = new Item();
        item2.setItemCount(2);
        item2.setProductCode("product_code2");
        item2.setProductName("product_name2");
        item2.setProductPrice(150F);
        items.add(item2);

        order.setItems(items);

        return order;
    }


}
