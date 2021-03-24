package com.example.PizzaApp.dto;

import com.example.PizzaApp.model.SizePrice;

import java.util.List;

public class SaleProductDto {

    private Integer proId;
    private String name;
    private String description;
    private Double basePrice;
    private String imgUrl;
    private String CategoryName;
    List<SizePrice> sizePrices;

    public SaleProductDto() {
    }

    public SaleProductDto(Integer proId, String name, String description, Double basePrice, String imgUrl, String categoryName, List<SizePrice> sizePrices) {
        this.proId = proId;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.imgUrl = imgUrl;
        this.CategoryName = categoryName;
        this.sizePrices = sizePrices;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public List<SizePrice> getSizePrices() {
        return sizePrices;
    }

    public void setSizePrices(List<SizePrice> sizePrices) {
        this.sizePrices = sizePrices;
    }
}
