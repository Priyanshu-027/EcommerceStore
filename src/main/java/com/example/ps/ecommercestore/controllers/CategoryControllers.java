package com.example.ps.ecommercestore.controllers;

import com.example.ps.ecommercestore.config.AppConstants;
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
    public ResponseEntity<CategoryResponse> getAllCategories(
            @RequestParam(name="pagenumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer PageNumber,
            @RequestParam(name="pagesize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer PageSize,
            @RequestParam(name="sortby",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
            @RequestParam(name="sortorder",defaultValue = AppConstants.SORT_ORDER,required = false) String sortOrder
    ){
        CategoryResponse categoryResponse = categoryService.getAllCategories(PageNumber,PageSize,sortBy,sortOrder);
        return ResponseEntity.ok().body(categoryResponse);
    }
    @PostMapping("/admin/categories")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
    CategoryDTO savedDto =  categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(201).body(savedDto);
    }
    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable int id){
    CategoryDTO deleteCategoryDto =  categoryService.deleteCategory(id);

        return ResponseEntity.status(200).body(deleteCategoryDto );

    }
    @PutMapping("/admin/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable int id,@RequestBody CategoryDTO categoryName){
        CategoryDTO updated =categoryService.updateCategory(id,categoryName);

        return ResponseEntity.ok(updated);

    }
}
