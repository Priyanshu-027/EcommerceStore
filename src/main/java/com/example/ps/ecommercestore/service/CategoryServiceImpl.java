package com.example.ps.ecommercestore.service;

import com.example.ps.ecommercestore.model.Category;
import com.example.ps.ecommercestore.repositories.CategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();
    @Autowired
    private CategoryRepositories categoryRepositories;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepositories.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepositories.save(category);
    }

    @Override
    public long deleteCategory(long id) {
//        long count = categories.stream().filter(c->c.getCategoryId()==id).count()
//            categories = categories.stream().filter(c->c.getCategoryId()!=id).collect(Collectors.toList());
        Optional<Category> category = categoryRepositories.findById(id);
        if (category.isPresent()){
            categoryRepositories.deleteById(id);
            return 1;
        }
        else {
            return 0;
        }




    }

    @Override
    public int updateCategory(long id, Category categoryNewName) {

        Optional<Category> category = categoryRepositories.findById(id);
        System.out.println("category update" + category.get());
        if(category.isPresent()){

            Category existing = category.get();

            existing.setCategoryName(categoryNewName.getCategoryName());

            categoryRepositories.save(existing);
            return 1;
        }
        else{
            return 0;
        }



//        return categories.stream()
//                .filter(c -> c.getCategoryId() == id)
//                .findFirst()
//                .map(c -> {
//                    c.setCategoryName(categoryName.getCategoryName());
//                    return 1;
//                })
//                .orElse(0);
    }
}
