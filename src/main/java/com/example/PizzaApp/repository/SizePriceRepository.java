package com.example.PizzaApp.repository;

import com.example.PizzaApp.model.SizePrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizePriceRepository extends JpaRepository<SizePrice,Integer> {
}
