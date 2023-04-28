package com.simplydev.bookslibrary.controller;

import com.simplydev.bookslibrary.entity.Book;
import com.simplydev.bookslibrary.entity.Category;
import com.simplydev.bookslibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booklibrary")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> categoryList(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{name}")
    public Optional<Category> getCategoryByName(@RequestBody Category category, @PathVariable("name") String name){
        return categoryService.getCategoryByName(category, name);
    }

    @PostMapping("/add_category")
    public void addNewCategory(@RequestBody Category category){
        categoryService.addNewCategory(category);
    }

    @DeleteMapping("/delete/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping("/edit/{categoryId}")
    public void editAuthor(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(required = false) String name
    ){
        categoryService.updateCategory(categoryId, name);
    }
}
