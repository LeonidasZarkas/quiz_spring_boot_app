package com.example.Quiz.services;

import java.util.List;
import com.example.Quiz.models.Category;
import com.example.Quiz.repos.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryServiceInterface{

    @Autowired
    CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).get();
    }
    
    @Override
    @Transactional
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }


    @Override
    @Transactional
    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }

}
