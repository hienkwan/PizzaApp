package com.example.PizzaApp.service;

import com.example.PizzaApp.model.Category;
import com.example.PizzaApp.model.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> findCategoryById(Integer id);
    Category addCategory(Category category);
    void deleteCategory(Integer id);
    Optional<Product> getAllProductsByCateId(Integer cateId);

}
