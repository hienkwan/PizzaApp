package com.example.PizzaApp.repository;

import com.example.PizzaApp.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void getCustomerTest(){
        List<Customer> customerList = customerRepository.findAll();
        System.out.println(customerList);
    }
}