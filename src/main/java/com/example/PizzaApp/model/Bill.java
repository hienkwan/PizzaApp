package com.example.PizzaApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bill")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime orderDateTime;

    private String orderType;

    private Long totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id")
    @JsonIgnore
    private List<BillDetail> billDetails;

    public void addCustomer(Customer customer) {
        addCustomer(customer,true);
    }

    void addCustomer(Customer customer,boolean b){
        this.customer=customer;
        if(customer!=null&&b){
            customer.addBill(this,true);
        }
    }

    @Override
    public String toString(){
        if(customer!=null){
            return orderType+" "+customer.toString();
        }
        return orderType;
    }
}
