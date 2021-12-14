package com.example.PizzaApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sizeprice")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SizePrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "sizepricename")
    private String name;

    @Column(name = "extraprice")
    private Double ExtraPrice;
}
