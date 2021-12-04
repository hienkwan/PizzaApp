package com.example.PizzaApp.repository;

import com.example.PizzaApp.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void printAllProductTest(){
        List<Product> products = productRepository.findAll();
        System.out.println(products);
    }

    @Test
    public void saveProductAndDeleteProductTest(){
        Product product = Product.builder()
                .name("Pizza test")
                .description("This is pizza test")
                .basePrice(30.0)
                .imgUrl("abc.png")
                .build();
        product.setCategory(categoryRepository.findById(1).get());
        int deleteId = productRepository.save(product).getId();
        productRepository.deleteById(deleteId);
    }
}