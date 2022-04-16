package com.jiker.service.provider.controller;


import com.jiker.service.provider.domain.Product;
import com.jiker.service.provider.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="vendor9082")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public List<Product> getProducts() {

        return productService.getProductsByVendorId(9082L);
    }
}
