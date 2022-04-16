package com.jiker.service.middle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jiker.service.middle.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductByProductCode(String productCode);

}
