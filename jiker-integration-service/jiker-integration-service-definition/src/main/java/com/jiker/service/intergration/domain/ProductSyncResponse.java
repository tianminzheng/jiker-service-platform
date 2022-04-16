package com.jiker.service.intergration.domain;

import java.io.Serializable;
import java.util.List;

public class ProductSyncResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String requestNo;//唯一请求编号
    private Long vendorId;//供应商Id
    private String vendorCode;//供应商编号

    private List<ProductItem> productItems;//商品数据

    public ProductSyncResponse() {
    }

    public ProductSyncResponse(String requestNo, Long vendorId, String vendorCode, List<ProductItem> productItems) {
        this.requestNo = requestNo;
        this.vendorId = vendorId;
        this.vendorCode = vendorCode;
        this.productItems = productItems;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }
}
