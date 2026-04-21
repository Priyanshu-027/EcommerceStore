package com.example.ps.ecommercestore.service;

import com.example.ps.ecommercestore.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();


    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }

    @Override
    public long deleteCategory(int id) {
        long count = categories.stream().filter(c->c.getCategoryId()==id).count();

            categories = categories.stream().filter(c->c.getCategoryId()!=id).collect(Collectors.toList());
            return count;



    }

    @Override
    public int updateCategory(int id, Category categoryName) {
        return categories.stream()
                .filter(c -> c.getCategoryId() == id)
                .findFirst()
                .map(c -> {
                    c.setCategoryName(categoryName.getCategoryName());
                    return 1;
                })
                .orElse(0);
    }
}
