package com.jiker.service.middle.service.impl.local;

import java.util.List;

import com.jiker.service.middle.domain.Product;

public interface ProductLocalService {

	//批量添加商品信息
    void addProducts(List<Product> products);

	//根据商品Id获取商品信息
    Product getProductById(Long id);

	//根据商品编号获取商品信息
    Product getProductByProductCode(String productCode);
}
