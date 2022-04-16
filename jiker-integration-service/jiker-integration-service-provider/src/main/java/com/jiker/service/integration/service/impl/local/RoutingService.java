package com.jiker.service.integration.service.impl.local;

import com.jiker.service.intergration.domain.ProductItem;

import java.util.List;

public interface RoutingService {

	//根据VendorId获取商品信息
    List<ProductItem> getProductsByVendorId(Long vendorId, String vendorSystemAddress);

    //根据VendorCode获取商品信息
    List<ProductItem> getProductsByVendorCode(String vendorCode, String vendorSystemAddress);
}
