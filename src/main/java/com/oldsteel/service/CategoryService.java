package com.oldsteel.service;

import com.oldsteel.entity.Category;
import com.oldsteel.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public Category createCategory(Category category){
        return categoryRepo.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    public Optional<Category> findById(Long categoryId){
        return categoryRepo.findById(categoryId);
    }
}
