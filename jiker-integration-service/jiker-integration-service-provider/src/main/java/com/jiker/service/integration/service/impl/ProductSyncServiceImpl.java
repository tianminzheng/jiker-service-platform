package com.jiker.service.integration.service.impl;

import com.jiker.service.intergration.domain.ProductItem;
import com.jiker.service.intergration.domain.ProductSyncRequest;
import com.jiker.service.intergration.domain.ProductSyncResponse;
import com.jiker.service.integration.service.ProductSyncService;
import com.jiker.service.integration.service.impl.local.RoutingService;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DubboService(version = "${integration.service.version}")
public class ProductSyncServiceImpl implements ProductSyncService {

    @Autowired
    private RoutingService routingService;

    @Override
    public ProductSyncResponse syncProduct(ProductSyncRequest request) {

        List<ProductItem> productItems = routingService.getProductsByVendorCode(request.getVendorCode(), request.getVendorSystemAddress());

        ProductSyncResponse response = new ProductSyncResponse();
        response.setRequestNo(request.getRequestNo());
        response.setVendorId(request.getVendorId());
        response.setVendorCode(request.getVendorCode());
        response.setProductItems(productItems);

        return response;
    }
}
