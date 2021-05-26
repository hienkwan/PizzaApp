package com.example.PizzaApp.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "order")
public class Order {
    @Id
    private Integer id;
    private Integer customerId;
    private LocalDateTime orderTime;
    private String orderType;
    private LocalDate orderDate;
    private Long totalPrice;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Collection<OrderDetail> orderDetails;

    public Order(){
    }

    public Order(Integer id,
                 Integer customerId,
                 LocalDateTime orderTime,
                 String orderType,
                 LocalDate orderDate,
                 Long totalPrice,
                 Collection<OrderDetail> orderDetails) {
        this.id = id;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.orderType = orderType;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderDetails = orderDetails;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Collection<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Collection<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
