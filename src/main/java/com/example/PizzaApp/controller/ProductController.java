package com.example.PizzaApp.controller;

import com.example.PizzaApp.dto.SaleProductDto;
import com.example.PizzaApp.model.Product;
import com.example.PizzaApp.model.SizePrice;
import com.example.PizzaApp.service.ProductService;
import com.example.PizzaApp.service.SizePriceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private SizePriceService sizePriceService;

    @Autowired
    private ModelMapper modelMapper;

    PropertyMap<Product, SaleProductDto> productMap = new PropertyMap <Product, SaleProductDto>() {
        protected void configure() {
            map().setProId(source.getId());
        }
    };

    public ProductController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(productMap);
    }

    @RequestMapping(value = "/api/products",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @RequestMapping(value = "/api/productSale",method = RequestMethod.GET)
    public ResponseEntity<List<SaleProductDto>> getAllSaleProduct(){
        List<Product> products = productService.getAllProduct();
       return new ResponseEntity<>(products.stream()
               .map(this::convertToDto)
               .collect(Collectors.toList()),HttpStatus.OK) ;
    }


    private SaleProductDto convertToDto(Product product) {
        SaleProductDto productDto = modelMapper.map(product, SaleProductDto.class);
        productDto.setSizePrices(sizePriceService.getAllSizePrice());
        return productDto;
    }




}
