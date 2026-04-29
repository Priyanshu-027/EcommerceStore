package com.example.ps.ecommercestore.service;

import com.example.ps.ecommercestore.exceptions.APIException;
import com.example.ps.ecommercestore.exceptions.ResourceNotFoundException;
import com.example.ps.ecommercestore.model.Category;
import com.example.ps.ecommercestore.payload.CategoryDTO;
import com.example.ps.ecommercestore.payload.CategoryRequestDTO;
import com.example.ps.ecommercestore.payload.CategoryResponse;
import com.example.ps.ecommercestore.repositories.CategoryRepositories;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.*;
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
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize,String sortBy,String sortOrder) {
        Sort sortbyandsortOrder = sortOrder.equalsIgnoreCase("asc")
                ? Sort.by(sortBy).ascending()
                :Sort.by(sortBy).descending();
        Pageable pageDetails = PageRequest.of(pageNumber,pageSize,sortbyandsortOrder);
        Page<Category> categoryPage = categoryRepositories.findAll(pageDetails);
        List<Category> categories = categoryPage.getContent();
        if(categories.isEmpty()){
            throw new APIException("no category is listed till now!!");
        }
        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category->modelMapper.map(category,CategoryDTO.class))
                .toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setTotalPages(categoryPage.getTotalPages());
        categoryResponse.setLastPage(categoryPage.isLast());
        return categoryResponse;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category existingCategory = categoryRepositories.findByCategoryName(category.getCategoryName());
        if(existingCategory != null){
            throw new APIException("Category with name " + category.getCategoryName()+" already exists");
        }
       Category saveCategory = categoryRepositories.save(category);
        CategoryDTO savedDto = modelMapper.map(saveCategory,CategoryDTO.class);
        return savedDto;
    }

    @Override
    public CategoryDTO deleteCategory(long id) {
//        long count = categories.stream().filter(c->c.getCategoryId()==id).count()
//            categories = categories.stream().filter(c->c.getCategoryId()!=id).collect(Collectors.toList());
        Category category = categoryRepositories.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","id",id));
CategoryDTO categoryDTO = modelMapper.map(category,CategoryDTO.class);
        categoryRepositories.deleteById(id);

        return categoryDTO;




    }

    @Override
    public CategoryDTO updateCategory(long id, CategoryDTO categoryDto) {
Category category = modelMapper.map(categoryDto,Category.class);
        Category existing = categoryRepositories.findById(id).orElseThrow(()->new ResourceNotFoundException("Category","id",id));

    existing.setCategoryName(category.getCategoryName());
     Category savedCategory =  categoryRepositories.save(existing);
    CategoryDTO updatedCategoryDto = modelMapper.map(savedCategory,CategoryDTO.class);
    return updatedCategoryDto;




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
