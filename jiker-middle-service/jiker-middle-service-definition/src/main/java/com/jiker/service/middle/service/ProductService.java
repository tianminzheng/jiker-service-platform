package com.jiker.service.middle.service;

import java.util.List;

import com.jiker.service.middle.domain.Product;

public interface ProductService {

	//从供应商系统中同步商品信息
    void syncProductsFromVendor(String vendorCode);

    //批量添加商品信息
    void addProducts(List<Product> products);

    //根据Id获取商品信息
    Product getProductById(Long id);

    //根据编号获取商品信息
    Product getProductByProductCode(String productCode);
}
