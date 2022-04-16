package com.jiker.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jiker.service.frontend.domain.Item;
import com.jiker.service.frontend.domain.Order;
import com.jiker.service.frontend.domain.OrderStatus;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {

    	//初始化Order对象
        Order order = buildOrder();
        HttpEntity<Order> request = new HttpEntity<>(order);

        //发送HTTP请求
        Order result = restTemplate.postForObject(
                "http://localhost:8000/orders",
                request,
                Order.class);

        //获取结果并打印
        System.out.println(result.getId());
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
