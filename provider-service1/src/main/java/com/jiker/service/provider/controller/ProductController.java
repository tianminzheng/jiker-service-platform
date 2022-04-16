package com.jiker.service.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiker.service.provider.domain.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="vendor9081")
public class ProductController {

    @GetMapping(value = "/products")
    public List<Product> getProducts() {

        //基于内存数据模拟返回
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, 9081L, "product_code_9081_1", "proudct_name_9081_1", "description", 10F));
        products.add(new Product(2L, 9081L, "product_code_9081_2", "proudct_name_9081_2", "description", 20F));

        return products;
    }
}
