package com.jiker.service.middle.service.impl;

import com.jiker.service.infrastructure.UniqueSequenceGenerator;
import com.jiker.service.infrastructure.exception.ServiceException;
import com.jiker.service.integration.service.ProductSyncService;
import com.jiker.service.intergration.domain.ProductItem;
import com.jiker.service.intergration.domain.ProductSyncRequest;
import com.jiker.service.intergration.domain.ProductSyncResponse;
import com.jiker.service.middle.domain.Product;
import com.jiker.service.middle.domain.VendorSystem;
import com.jiker.service.middle.service.ProductService;
import com.jiker.service.middle.service.impl.local.ProductLocalService;
import com.jiker.service.middle.service.impl.local.VendorSystemLocalService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@DubboService(version = "${middle.service.version}")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private VendorSystemLocalService vendorSystemLocalService;

    @Autowired
    private ProductLocalService productLocalService;

    @DubboReference(version = "${integration.service.version}", timeout = 3000)
    private ProductSyncService productSyncService;

    @Override
    public void syncProductsFromVendor(String vendorCode) {

        //判断VendorCode是否有效
        VendorSystem vendorSystem = vendorSystemLocalService.getVendorSystemByVendorCode(vendorCode);
        if(vendorSystem == null)
            throw new ServiceException("The vendor system:" + vendorCode + " is not existed!");

        //构建远程请求对象
        ProductSyncRequest request = new ProductSyncRequest();

        String requestNo = UniqueSequenceGenerator.getInstance().getUniqueSequence();
        request.setRequestNo(requestNo);
        request.setVendorId(vendorSystem.getId());
        request.setVendorCode(vendorSystem.getVendorCode());

        //通过VendorSystem组装目标供应商系统的访问地址
        StringBuilder vendorAddress = new StringBuilder();
        vendorAddress.append(vendorSystem.getIp()).append(":").append(vendorSystem.getPort());
        request.setVendorSystemAddress(vendorAddress.toString());

        //执行Dubbo远程调用，获取商品同步信息结果
        ProductSyncResponse response = productSyncService.syncProduct(request);

        List<ProductItem> productItems = response.getProductItems();

        //将结果对象转化为Product对象       
        List<Product> products = convertProductItems(productItems);

        //执行持久化操作
        this.addProducts(products);

    }

    @Override
    public void addProducts(List<Product> products) {

        productLocalService.addProducts(products);
    }

    @Override
    public Product getProductById(Long id) {

        return productLocalService.getProductById(id);
    }

    @Override
    public Product getProductByProductCode(String productCode) {

        return productLocalService.getProductByProductCode(productCode);
    }

    private List<Product> convertProductItems(List<ProductItem> productItems) {

        List<Product> products = new ArrayList<Product>();

        if(productItems == null || productItems.size() == 0)
            return products;

        for(ProductItem productItem : productItems) {
            Product product = new Product();

            //不需要转Id
            product.setVendorId(productItem.getVendorId());
            product.setProductCode(productItem.getProductCode());
            product.setProductName(productItem.getProductName());
            product.setDescription(productItem.getDescription());
            product.setPrice(productItem.getPrice());
            products.add(product);
        }

        return products;
    }
}
