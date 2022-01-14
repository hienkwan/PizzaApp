package com.example.PizzaApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;

    @Column(name = "phonenumber")
    private String phoneNumber;

    private String Address;

    @Column(name = "user_role")
    private Integer user_role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer",
            fetch = FetchType.EAGER)
    private List<Bill> bills;

    @Override
    public String toString() {
        return username;
    }

    public void addBill(Bill bill) {
        addBill(bill, true);
    }

    void addBill(Bill bill, boolean b) {
        if (bill != null) {
            if(getBills()==null){
                bills = new ArrayList<>();
                getBills().add(bill);
            }else {
                getBills().add(bill);
            }
            if (b) {
                bill.addCustomer(this, false);
            }
        }
    }

    public void removeBill(Bill bill) {
        getBills().remove(bill);
        bill.setCustomer(null);
    }
}
