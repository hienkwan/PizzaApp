package com.example.PizzaApp.service;

import com.example.PizzaApp.model.Bill;
import com.example.PizzaApp.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class BillServiceImpl implements BillService{
    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> findBillWithDate(LocalDate date) {
        return  billRepository.findBillByOrderDateTime(date);
    }
}
