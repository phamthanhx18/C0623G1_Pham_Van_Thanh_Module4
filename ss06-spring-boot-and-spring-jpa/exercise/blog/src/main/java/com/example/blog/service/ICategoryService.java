package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
    void createCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(Integer id);
    Category findCategoryById(Integer id);
}
