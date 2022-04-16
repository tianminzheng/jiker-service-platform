package com.jiker.service.intergration.domain;

import java.io.Serializable;

//在处于底层的集成服务中，用ProductItem来代表商品信息
//在中台服务中，完成ProductItem与Product之间的数据转换
public class ProductItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;//商品Id
    private Long vendorId;//供应商Id
    private String productCode;//商品编号
    private String productName;//商品名称
    private String description;//商品描述
    private Float price;//商品价格

    public ProductItem() {
    }

    public ProductItem(Long id, Long vendorId, String productCode, String productName, String description, Float price) {
        this.id = id;
        this.vendorId = vendorId;
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
