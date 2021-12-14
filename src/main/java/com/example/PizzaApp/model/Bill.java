package com.example.PizzaApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerid")
    @JsonIgnore
    private Customer customer;

    private LocalDateTime orderTime;

    private String orderType;

    private LocalDate orderDate;

    private Long totalPrice;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<BillDetail> billDetails;
}
