package com.simplydev.bookslibrary.service;

import com.simplydev.bookslibrary.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    void addNewCategory(Category category);

    void deleteCategory(Long categoryId);

    Optional<Category> getCategoryByName(Category category, String name);

    void updateCategory(Long categoryId, String name);
}
