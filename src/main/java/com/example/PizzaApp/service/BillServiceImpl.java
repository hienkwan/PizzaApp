package com.example.PizzaApp.service;

import com.example.PizzaApp.dto.BillDto;
import com.example.PizzaApp.model.Bill;
import com.example.PizzaApp.model.Customer;
import com.example.PizzaApp.repository.BillRepository;
import com.example.PizzaApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillServiceImpl implements BillService{
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Bill> findBillWithDate(LocalDate date) {
        return  billRepository.findBillByOrderDateTime(date);
    }

    @Override
    public Bill createBill(BillDto billDto) {
        Customer orderCustomer = customerRepository.findCustomerById(billDto.getCustomerId());
        Bill bill = Bill.builder()
                .orderDateTime(billDto.getOrderDateTime())
                .orderType(billDto.getOrderType())
                .totalPrice(billDto.getTotalPrice())
                .billDetails(billDto.getBillDetails())
                .build();
        bill.addCustomer(orderCustomer);
        return billRepository.save(bill);
    }
}
