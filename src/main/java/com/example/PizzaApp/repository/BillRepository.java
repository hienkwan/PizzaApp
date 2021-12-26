package com.example.PizzaApp.repository;

import com.example.PizzaApp.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "SELECT e.* FROM bill e WHERE DATE(order_date_time) =:date", nativeQuery = true)
    List<Bill> findBillByOrderDateTime(LocalDate date);
}
