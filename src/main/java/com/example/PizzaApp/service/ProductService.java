package com.example.PizzaApp.service;

import com.example.PizzaApp.dto.SaleProductDto;
import com.example.PizzaApp.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProduct();

    Optional<Product> getProductById(Integer id);
    Product addProduct(Product product);

    void deleteProduct(Integer id);

}
