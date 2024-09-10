package com.example.services;

import com.example.models.dbModels.Categories;
import com.example.models.dtoModels.CategoriesDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService
{
    ResponseEntity<Categories> addingCategory(CategoriesDto cDto);

    ResponseEntity<List<Categories>> getAllCategories();

    ResponseEntity<Categories> getCategory(String categoryName);

    ResponseEntity<Categories> updatingCategory(int id, CategoriesDto cDto);
}
