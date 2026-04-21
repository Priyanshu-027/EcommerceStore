package com.example.ps.ecommercestore.controllers;

import com.example.ps.ecommercestore.model.Category;
import com.example.ps.ecommercestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryControllers {

    @Autowired
   private CategoryService categoryService;

    @GetMapping("/public/categories")
    public List<Category> getAllCategories(){

        return categoryService.getAllCategories();
    }
    @PostMapping("/admin/categories")
    public ResponseEntity<String> addCategory(@RequestBody Category category){
    categoryService.createCategory(category);
        return ResponseEntity.status(201).body("added successfully");
    }
    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id){
       long deleteCount = categoryService.deleteCategory(id);
       if(deleteCount != 0)
        return ResponseEntity.status(200).body("deleted successfully" );
       else return ResponseEntity.notFound().build();
    }
    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable int id,@RequestBody Category categoryName){
        int res =categoryService.updateCategory(id,categoryName);
        if(res!=0)
        return ResponseEntity.status(200).body("updated successfully" );
        else{
            return ResponseEntity.status(404).body("some error has occurred or not found" );
        }
    }
}
