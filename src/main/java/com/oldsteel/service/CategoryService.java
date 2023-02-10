package com.oldsteel.service;

import com.oldsteel.entity.Category;
import com.oldsteel.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public Category createCategory(Category category){
        return categoryRepo.save(category);
    }
}
