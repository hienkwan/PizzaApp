package com.example.PizzaApp.service;

import com.example.PizzaApp.exception.ResourceNotFoundException;
import com.example.PizzaApp.model.Category;
import com.example.PizzaApp.model.Product;
import com.example.PizzaApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoriesReturn = categoryRepository.findAll();
        return categoriesReturn;
    }

    @Override
    public Optional<Category> findCategoryById(Integer id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category;
    }

    @Override
    public Category addCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }




}
