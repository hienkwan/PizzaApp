package com.example.PizzaApp.controller;

import com.example.PizzaApp.dto.BillDto;
import com.example.PizzaApp.model.Bill;
import com.example.PizzaApp.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {
    @Autowired
    private BillService billService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/billsWithDate/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> getAllBillWithDate(String date) {
        LocalDate dateToFind = LocalDate.parse(date);
        List<Bill> billList = billService.findBillWithDate(dateToFind);
        return new ResponseEntity<>(billList, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @RequestMapping(value = "/bill", method = RequestMethod.POST)
    public ResponseEntity<Bill> createBill(@RequestBody BillDto billDto) {
        Bill billSaved = billService.createBill(billDto);
        return new ResponseEntity<>(billSaved, HttpStatus.OK);
    }
}
