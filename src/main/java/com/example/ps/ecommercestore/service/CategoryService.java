package com.example.ps.ecommercestore.service;

import com.example.ps.ecommercestore.model.Category;
import com.example.ps.ecommercestore.payload.CategoryDTO;
import com.example.ps.ecommercestore.payload.CategoryRequestDTO;
import com.example.ps.ecommercestore.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {

   CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(long id);
    CategoryDTO updateCategory(long id,CategoryDTO categoryDto);
}
