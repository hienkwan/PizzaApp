package com.example.PizzaApp.controller;

import com.example.PizzaApp.dto.SaleProductDto;
import com.example.PizzaApp.exception.ResourceNotFoundException;
import com.example.PizzaApp.model.Product;
import com.example.PizzaApp.repository.CategoryRepository;
import com.example.PizzaApp.service.ProductService;
import com.example.PizzaApp.service.SizePriceService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private SizePriceService sizePriceService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    PropertyMap<Product, SaleProductDto> productMap = new PropertyMap <Product, SaleProductDto>() {
        protected void configure() {
            map().setProId(source.getId());
        }
    };

    @Autowired
    public ProductController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(productMap);
    }

    @RequestMapping(value = "/api",method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @RequestMapping(value = "/management/api/{cateId}",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Product> addProduct(@PathVariable(value = "cateId")Integer cateId,@RequestBody Product product){
        return categoryRepository.findById(cateId).map(category -> {
            product.setCategory(category);
            productService.addProduct(product);
            return new ResponseEntity<>(product,HttpStatus.OK);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + cateId + " not found"));
    }

    @RequestMapping(value = "/management/api/{cateId}/{productId}",method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "cateId")Integer cateId,@PathVariable(value = "productId")Integer productId,
                                 @RequestBody Product product){
        return categoryRepository.findById(cateId).map(category -> {
            Product productUpdated = productService.getProductById(productId).map(productDestination->{
                productDestination.setCategory(category);
                productDestination.setName(product.getName());
                productDestination.setBasePrice(product.getBasePrice());
                productDestination.setImgUrl(product.getImgUrl());
                productDestination.setDescription(product.getDescription());
                productService.addProduct(productDestination);
                return productDestination;
             }).get();
            return new ResponseEntity<>(productUpdated,HttpStatus.OK);
        }).get();
    }

    @RequestMapping(value = "/management/api/{productId}",method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteProduct(@PathVariable(value = "productId")Integer productId){
        productService.deleteProduct(productId);
    }

    @RequestMapping(value = "/api/productSale",method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('product:read')")
    public ResponseEntity<List<SaleProductDto>> getAllSaleProduct(){
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList()),HttpStatus.OK) ;
    }

    @RequestMapping(value = "/api/productSaleById/{productId}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<SaleProductDto> getSaleProductById(@PathVariable("productId") Integer productId){
        Optional<Product> product = productService.getProductById(productId);
        SaleProductDto dataReturn = new SaleProductDto();
        dataReturn = convertToDto(product.get());
        return new ResponseEntity<>(dataReturn,HttpStatus.OK) ;
    }

    private SaleProductDto convertToDto(Product product) {
        SaleProductDto productDto = modelMapper.map(product, SaleProductDto.class);
        productDto.setSizePrices(sizePriceService.getAllSizePrice());
        return productDto;
    }
}
