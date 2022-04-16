package com.jiker.service.frontend.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jiker.service.middle.service.ProductService;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @DubboReference(version = "${middle.service.version}")
    private ProductService productService;

    @PostMapping(value = "/{vendorCode}")
    public void syncProductsFromVendor(@PathVariable String vendorCode) {

        productService.syncProductsFromVendor(vendorCode);
    }

}
