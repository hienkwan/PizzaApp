package com.example.PizzaApp.controller;

import com.example.PizzaApp.model.Customer;
import com.example.PizzaApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ResponseEntity<String> createNewCustomer(@RequestBody Customer customer){
        String username =customerService.signup(customer);
        return new ResponseEntity<>(username, HttpStatus.OK);
    }

}
