package com.example.PizzaApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "billdetail")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer productId;
    private Integer quantity;
    private Integer sizeId;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
}
