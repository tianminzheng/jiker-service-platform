package com.jiker.service.frontend;

import com.jiker.service.frontend.domain.Item;
import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;
import com.jiker.service.frontend.service.OrderService;
import com.jiker.service.middle.service.AccountService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceTests {

    @DubboReference(version = "${frontend.service.version}", timeout = 3000)
    private OrderService orderService;

    @Test
    public void testAddOrder() throws Exception {

        Order order = buildOrder();

        orderService.addOrder(order);
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
