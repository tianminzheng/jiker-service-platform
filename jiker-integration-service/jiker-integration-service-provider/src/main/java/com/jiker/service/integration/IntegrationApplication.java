package com.jiker.service.integration;

import com.jiker.service.intergration.domain.ProductSyncRequest;
import com.jiker.service.intergration.domain.ProductSyncResponse;
import com.jiker.service.integration.service.ProductSyncService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class IntegrationApplication  { //implements CommandLineRunner

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(IntegrationApplication.class, args);
    }

//    @DubboReference(version = "${integration.service.version}")
//    private ProductSyncService productSyncService;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        ProductSyncRequest request = new ProductSyncRequest();
//        request.setRequestNo("UniqueRequestNo");
//        request.setVendorId(9082L);
//        request.setVendorCode("9082");
//        request.setVendorSystemAddress("127.0.0.1:9082");
//
//        ProductSyncResponse response = productSyncService.syncProduct(request);
//
//        System.out.println(response.getProductItems().size());
//    }
}
