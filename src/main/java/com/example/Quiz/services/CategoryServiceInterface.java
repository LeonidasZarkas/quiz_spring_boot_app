package com.example.Quiz.services;

import java.util.List;
import com.example.Quiz.models.Category;

public interface CategoryServiceInterface {
    
    public List<Category> getAllCategories();
    public Category getCategoryById(Integer id);
    public void createCategory(Category category);
    public void deleteCategoryById(Integer id);
}
