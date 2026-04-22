package com.example.ps.ecommercestore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {

//    static long countId =0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private String categoryName;


    public Category( String categoryName) {
//        this.categoryId = ++countId;
        this.categoryName = categoryName;
    }

    public Category() {

    }

    public long getCategoryId() {
        return categoryId;
    }



    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
