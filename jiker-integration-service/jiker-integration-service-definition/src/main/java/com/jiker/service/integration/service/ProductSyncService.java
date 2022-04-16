package com.jiker.service.integration.service;

import com.jiker.service.intergration.domain.ProductSyncRequest;
import com.jiker.service.intergration.domain.ProductSyncResponse;

public interface ProductSyncService {

	//同步商品
    ProductSyncResponse syncProduct(ProductSyncRequest request);
}
