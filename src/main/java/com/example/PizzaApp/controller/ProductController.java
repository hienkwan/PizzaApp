package com.example.PizzaApp.controller;

import com.example.PizzaApp.model.Product;
import com.example.PizzaApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/api/products",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }


}
