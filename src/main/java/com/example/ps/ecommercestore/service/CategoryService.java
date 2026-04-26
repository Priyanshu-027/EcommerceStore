package com.example.ps.ecommercestore.service;

import com.example.ps.ecommercestore.model.Category;
import com.example.ps.ecommercestore.payload.CategoryDTO;
import com.example.ps.ecommercestore.payload.CategoryRequestDTO;
import com.example.ps.ecommercestore.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

   CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    void deleteCategory(long id);
    Category updateCategory(long id,Category categoryName);
}
