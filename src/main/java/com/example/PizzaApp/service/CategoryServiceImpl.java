package com.example.PizzaApp.service;

import com.example.PizzaApp.model.Category;
import com.example.PizzaApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoriesReturn = categoryRepository.findAll();
        return categoriesReturn;
    }
}
