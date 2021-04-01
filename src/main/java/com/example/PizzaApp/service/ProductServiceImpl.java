package com.example.PizzaApp.service;

import com.example.PizzaApp.dto.SaleProductDto;
import com.example.PizzaApp.model.Product;
import com.example.PizzaApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Product> getProductById(Integer id) {
        Optional<Product> productReturn = productRepository.findById(id);
        return productReturn;
    }

    @Override
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }


}
