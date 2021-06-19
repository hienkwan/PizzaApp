package com.example.PizzaApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "bill")
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "customerid")
    @JsonIgnore
    private Customer customer;


    private LocalDateTime orderTime;


    private String orderType;


    private LocalDate orderDate;

    private Long totalPrice;

    @OneToMany(mappedBy = "bill",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<BillDetail> billDetails;

    public Bill(){
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Collection<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(Collection<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }
}
