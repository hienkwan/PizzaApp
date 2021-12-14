package com.example.PizzaApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer implements Serializable {

    @Id
    private int id;
    private String username;
    private String password;

    @Column(name = "phonenumber")
    private String phoneNumber;

    private String Address;

    @Column(name = "user_role")
    private Integer user_role;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Bill> bills;
}
