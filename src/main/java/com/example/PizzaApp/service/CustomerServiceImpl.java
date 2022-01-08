package com.example.PizzaApp.service;

import com.example.PizzaApp.model.Customer;
import com.example.PizzaApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.PizzaApp.utils.MD5.getMd5;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;



    @Override
    public String signup(Customer customer) {
        String hash ="ABC123456789";
        String password = customer.getPassword();
        String passwordToMd5 = getMd5(password);
        customer.setPassword(passwordToMd5);
        Customer customerSaved = customerRepository.save(customer);
        return customerSaved.getUsername();
    }
}
