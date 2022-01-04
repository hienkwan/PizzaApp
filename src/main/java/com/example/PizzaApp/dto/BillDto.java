package com.example.PizzaApp.dto;

import com.example.PizzaApp.model.BillDetail;

import java.time.LocalDateTime;
import java.util.List;

public class BillDto {
    private int id;
    private int customerId;
    private LocalDateTime orderDateTime;

    private String orderType;

    private Long totalPrice;
    private List<BillDetail> billDetails;
}
