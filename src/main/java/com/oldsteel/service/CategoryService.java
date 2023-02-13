package com.oldsteel.service;

import com.oldsteel.entity.Category;
import com.oldsteel.entity.Product;
import com.oldsteel.repository.CategoryRepository;
import com.oldsteel.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;

    public Category createCategory(Category category){
        return categoryRepo.save(category);
    }

    public void insertBookToCategory(Long categoryId, Long productId){
        var product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found..."));
        var category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found... Please create one"));
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        category.setProducts(productList);
        categoryRepo.save(category);
    }
}
