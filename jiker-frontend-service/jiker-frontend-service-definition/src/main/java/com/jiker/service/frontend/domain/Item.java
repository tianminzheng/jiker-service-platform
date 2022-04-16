package com.jiker.service.frontend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //反向引用OrderId，建立起Order和Item之间的关联关系
    private Long orderId;
    private String productCode;
    private String productName;
    private Float productPrice;
    private int itemCount;

    public Item() {
    }

    public Item(Long id, Long orderId, String productCode, String productName, Float productPrice, int itemCount) {
        this.id = id;
        this.orderId = orderId;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.itemCount = itemCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
