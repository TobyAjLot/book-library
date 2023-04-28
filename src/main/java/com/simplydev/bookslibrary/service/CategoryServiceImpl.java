package com.simplydev.bookslibrary.service;

import com.simplydev.bookslibrary.entity.Category;
import com.simplydev.bookslibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryByName(Category category, String name) {
        return categoryRepository.findCategoryByName(name);
    }

    @Override
    public void addNewCategory(Category category) {
        Optional<Category> categoryOptional = categoryRepository.findCategoryByName(category.getName());
        if(categoryOptional.isPresent()){
            throw new IllegalStateException("Category already exist");
        }
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        boolean exists = categoryRepository.existsById(categoryId);
        if (!exists){
            throw new IllegalStateException("Category with name " + categoryId + "does not exist");
        }
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public void updateCategory(Long categoryId, String name) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException(
                        "category with id " + categoryId + " does not exist"));
        if (!Objects.equals(category.getName(), name)) {
            category.setName(name);
        }
    }

}
