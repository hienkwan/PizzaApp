package com.example.PizzaApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "productname")
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(name = "baseprice")
    private Double basePrice;

    @Column(name = "imgurl")
    private String imgUrl;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "cateid")
    @JsonIgnore
    private Category category;

//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Double getBasePrice() {
//        return basePrice;
//    }
//
//    public void setBasePrice(Double basePrice) {
//        this.basePrice = basePrice;
//    }
//
//    public String getImgUrl() {
//        return imgUrl;
//    }
//
//    public void setImgUrl(String imgUrl) {
//        this.imgUrl = imgUrl;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    @Override
    public String toString() {
        return name+" "+description+" "+basePrice+" "+category.getName();
    }
}
