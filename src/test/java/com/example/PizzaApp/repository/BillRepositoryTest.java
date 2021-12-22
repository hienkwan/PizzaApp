package com.example.PizzaApp.repository;

import com.example.PizzaApp.model.Bill;
import com.example.PizzaApp.model.BillDetail;
import com.example.PizzaApp.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class BillRepositoryTest {
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void addBillWithExitsCustomerTest(){



        Customer customer=  customerRepository.findCustomerById(3);
        //System.out.println(customer1);

        BillDetail billDetail = BillDetail.builder()
                .productId(1)
                .quantity(50)
                .sizeId(2)
                .build();

        Bill bill = Bill.builder()
                .orderDateTime(LocalDateTime.now())
                .orderType("premise")
                .totalPrice(10002l)
                .billDetails(List.of(billDetail))
                .build();
        bill.addCustomer(customer);

        billRepository.save(bill);


    }

    @Test
    public void addBillWithNewCustomerTest(){
        Customer customer = Customer.builder()
                .username("eva")
                .password("1234")
                .Address("")
                .phoneNumber("01233456789")
                .user_role(1)
                .build();
        Customer customerSaved = customerRepository.save(customer);
        System.out.println(customerSaved);

        BillDetail billDetail = BillDetail.builder()
                .productId(1)
                .quantity(50)
                .sizeId(2)
                .build();

        Bill bill = Bill.builder()
                .orderDateTime(LocalDateTime.now())
                .orderType("premise1")
                .totalPrice(10002l)
                .billDetails(List.of(billDetail))
                .build();
        bill.addCustomer(customerSaved);

        billRepository.save(bill);
    }
}