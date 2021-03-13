package com.example.PizzaApp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sizeprice")
public class SizePrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "sizepricename")
    private String name;

    @Column(name = "extraprice")
    private Double ExtraPrice;

    public SizePrice(){
    }

    public SizePrice(Integer id, String name, Double extraPrice) {
        this.id = id;
        this.name = name;
        ExtraPrice = extraPrice;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getExtraPrice() {
        return ExtraPrice;
    }

    public void setExtraPrice(Double extraPrice) {
        ExtraPrice = extraPrice;
    }
}
