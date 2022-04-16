package com.jiker.service.provider.service.impl;

import com.jiker.service.provider.domain.Product;
import com.jiker.service.provider.repository.ProductRepository;
import com.jiker.service.provider.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductsByVendorId(Long vendorId) {

        return productRepository.getProductsByVendorId(vendorId);
    }
}
