package com.example.PizzaApp.service;

import com.example.PizzaApp.dto.BillDto;
import com.example.PizzaApp.model.Bill;

import java.time.LocalDate;
import java.util.List;

public interface BillService {
    List<Bill> findBillWithDate(LocalDate date);

    Bill createBill(BillDto billDto);
}
