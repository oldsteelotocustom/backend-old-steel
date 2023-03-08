package com.oldsteel.service;

import com.oldsteel.entity.ProductCategory;
import com.oldsteel.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository categoryRepo;

    public ProductCategory createCategory(ProductCategory productCategory){
        return categoryRepo.save(productCategory);
    }

    public List<ProductCategory> getAllCategories(){
        return categoryRepo.findAll();
    }

    public Optional<ProductCategory> findById(Long categoryId){
        return categoryRepo.findById(categoryId);
    }

    public void deleteProductCategory(Long productCategoryId){
        categoryRepo.deleteById(productCategoryId);
    }
}
