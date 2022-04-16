package com.jiker.service.middle.service.impl.local.impl;

import com.jiker.service.middle.domain.Product;
import com.jiker.service.middle.repository.ProductRepository;
import com.jiker.service.middle.service.impl.local.ProductLocalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLocalServiceImpl implements ProductLocalService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProducts(List<Product> products) {

        productRepository.saveAll(products);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product getProductByProductCode(String productCode) {
        return productRepository.getProductByProductCode(productCode);
    }
}
