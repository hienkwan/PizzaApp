package com.example.PizzaApp.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderDetail {
    @Id
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private Integer sizeId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderDetail(){
    }

    public OrderDetail(Integer id,
                       Integer productId,
                       Integer quantity,
                       Integer sizeId,
                       Order order) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.sizeId = sizeId;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
