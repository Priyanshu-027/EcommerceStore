package com.example.ps.ecommercestore.model;

public class Category {
    static long countId =0;
    private long categoryId;
    private String categoryName;


    public Category( String categoryName) {
        this.categoryId = ++countId;
        this.categoryName = categoryName;
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
