package com.jiker.service.provider.service;

import java.util.List;

import com.jiker.service.provider.domain.Product;

public interface ProductService {

    List<Product> getProductsByVendorId(Long vendorId);
}
