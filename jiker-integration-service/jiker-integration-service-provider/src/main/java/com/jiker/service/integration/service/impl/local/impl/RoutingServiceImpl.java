package com.jiker.service.integration.service.impl.local.impl;

import com.jiker.service.intergration.domain.ProductItem;
import com.jiker.service.integration.service.impl.local.RoutingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//RoutingService通过RESTful请求来远程访问ProviderService
@Service
public class RoutingServiceImpl implements RoutingService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<ProductItem> getProductsByVendorId(Long vendorId, String vendorSystemAddress) {
        return getProductsFromVendor(vendorId.toString(), vendorSystemAddress);
    }

    @Override
    public List<ProductItem> getProductsByVendorCode(String vendorCode, String vendorSystemAddress) {
        return getProductsFromVendor(vendorCode, vendorSystemAddress);
    }

    private List<ProductItem> getProductsFromVendor(String vendor, String vendorSystemAddress) {

//        VenderSystem控制访问根路径
//        IP:Port
//        路由器控制访问子路径
//        vendor+vendorId或Code/products
        //例如：http://127.0.0.1:8080/vendor001/products
        StringBuilder vendorAddress = new StringBuilder();
        vendorAddress.append("http://").append(vendorSystemAddress);
        vendorAddress.append("/vendor").append(vendor);
        vendorAddress.append("/products");

        ResponseEntity<ProductItem[]> result = restTemplate.exchange(
                vendorAddress.toString(),
                HttpMethod.GET,
                null,
                ProductItem[].class
        );

        ProductItem[] productItems = result.getBody();

        return Arrays.asList(productItems);
    }
}
