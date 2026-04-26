package com.example.ps.ecommercestore.controllers;

import com.example.ps.ecommercestore.model.Category;
import com.example.ps.ecommercestore.payload.CategoryDTO;
import com.example.ps.ecommercestore.payload.CategoryRequestDTO;
import com.example.ps.ecommercestore.payload.CategoryResponse;
import com.example.ps.ecommercestore.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryControllers {

    @Autowired
   private CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<CategoryResponse> getAllCategories(){
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        return ResponseEntity.ok().body(categoryResponse);
    }
    @PostMapping("/admin/categories")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
    CategoryDTO savedDto =  categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(201).body(savedDto);
    }
    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id){
      categoryService.deleteCategory(id);

        return ResponseEntity.status(200).body("deleted successfully" );

    }
    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id,@RequestBody Category categoryName){
        Category updated =categoryService.updateCategory(id,categoryName);

        return ResponseEntity.ok(updated);

    }
}
