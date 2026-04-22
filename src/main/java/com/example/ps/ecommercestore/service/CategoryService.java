package com.example.ps.ecommercestore.service;

import com.example.ps.ecommercestore.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory(Category category);

    long deleteCategory(long id);
    int updateCategory(long id,Category categoryName);
}
