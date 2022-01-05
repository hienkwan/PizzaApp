package com.example.PizzaApp.dto;

import com.example.PizzaApp.model.BillDetail;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BillDto {
    private int customerId;
    private LocalDateTime orderDateTime;

    private String orderType;

    private Long totalPrice;
    private List<BillDetail> billDetails;
}
