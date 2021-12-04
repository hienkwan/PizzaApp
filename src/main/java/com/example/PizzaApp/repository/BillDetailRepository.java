package com.example.PizzaApp.repository;

import com.example.PizzaApp.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDetailRepository extends JpaRepository< BillDetail,Integer> {
}
