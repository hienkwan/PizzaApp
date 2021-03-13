package com.example.PizzaApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private int id;
    private String username;
    private String password;
    private String phoneNumber;
    private String Address;
}
