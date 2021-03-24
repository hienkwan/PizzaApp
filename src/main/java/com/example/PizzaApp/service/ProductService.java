package com.example.PizzaApp.service;

import com.example.PizzaApp.dto.SaleProductDto;
import com.example.PizzaApp.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    List<SaleProductDto> getSaleProduct();
}
