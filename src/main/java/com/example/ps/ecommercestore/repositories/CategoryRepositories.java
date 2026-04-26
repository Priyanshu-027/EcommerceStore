package com.example.ps.ecommercestore.repositories;

import com.example.ps.ecommercestore.model.Category;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositories extends JpaRepository<Category, Long> {


    Category findByCategoryName(@NotBlank String categoryName);
}
