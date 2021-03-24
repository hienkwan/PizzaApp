package com.example.PizzaApp.service;

import com.example.PizzaApp.dto.SaleProductDto;
import com.example.PizzaApp.model.Product;
import com.example.PizzaApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        List<Product> productsReturn = productRepository.findAll();
        return productsReturn;
    }

    @Override
    public List<SaleProductDto> getSaleProduct() {
        return null;
    }


}
