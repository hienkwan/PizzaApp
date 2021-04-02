package com.example.PizzaApp.controller;

import com.example.PizzaApp.model.Category;
import com.example.PizzaApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @RequestMapping(value = "/api/categories",method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/management/api/category",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Category> addCategory( @RequestBody Category category){
        Category categoryReturn = categoryService.addCategory(category);
        return new ResponseEntity<>(categoryReturn,HttpStatus.OK);
    }

    @RequestMapping(value = "/management/api/category/{cateId}",method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Category> updateCategory(@PathVariable(name = "cateId")Integer cateId,@RequestBody Category category){
        return categoryService.findCategoryById(cateId).map(categoryUpdate ->{
           categoryUpdate.setName(category.getName());
            Category categoryReturn = categoryService.addCategory(categoryUpdate);
           return new ResponseEntity<>(categoryReturn,HttpStatus.OK);
        }).get();
    }

    @RequestMapping(value = "/management/api/category/{cateId}",method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteCategory(@PathVariable(name = "cateId")Integer cateId){
        categoryService.deleteCategory(cateId);
    }
}
