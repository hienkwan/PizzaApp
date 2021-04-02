package com.example.PizzaApp.repository;

import com.example.PizzaApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findById(Integer id);
    void deleteById(Integer id);
}
