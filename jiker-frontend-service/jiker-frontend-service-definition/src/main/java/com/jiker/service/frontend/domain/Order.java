package com.jiker.service.frontend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountId;

    @Transient
    private List<Item> items = new ArrayList<>();
    private OrderStatus status;

    public Order() {
    }

    public Order(Long id, Long accountId, List<Item> items, OrderStatus status) {
        this.id = id;
        this.accountId = accountId;
        this.items = items;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Float getTotalPrice() {
        Float totalPrice = 0.0F;

        if(items == null || items.size() == 0)
            return totalPrice;

        for(Item item : items) {
            totalPrice += item.getProductPrice() * item.getItemCount();
        }

        return totalPrice;
    }
}
