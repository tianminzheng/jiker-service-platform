package com.jiker.service.middle;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jiker.service.middle.service.ProductService;

@SpringBootApplication
public class MiddleApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(MiddleApplication.class, args);
    }

    @DubboReference(version = "${middle.service.version}", timeout = 3000)
    private ProductService productService;


    @Override
    public void run(String... args) throws Exception {

        productService.syncProductsFromVendor("9081");
    }
}
