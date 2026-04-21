package com.example.ps.ecommercestore.service;

import com.example.ps.ecommercestore.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);

    long deleteCategory(int id);
    int updateCategory(int id,Category categoryName);
}
