//package com.jiker.service.middle.service.impl.local;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//import com.jiker.service.middle.domain.Product;
//import com.jiker.service.middle.repository.ProductRepository;
//
//public class ProductRepositoryImpl implements ProductRepository {
//
//	@Override
//	public Product getProductByProductCode(String productCode) {
//		Product stubProduct = new Product();
//		stubProduct.setId(001L);
//		stubProduct.setVendorId(001L);
//		stubProduct.setProductCode("productCode1");
//		stubProduct.setProductName("productName1");
//		stubProduct.setDescription("description");
//		stubProduct.setPrice(100.0F);
//		
//		return stubProduct;
//	}
//}
