package com.oldsteel.service;

import com.oldsteel.entity.Product;
import com.oldsteel.repository.CategoryRepository;
import com.oldsteel.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public Product saveProduct(Product product){
        product.setAvailability(true);
        return productRepo.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @Transactional
    public void insertBookToCategory(Long productId, Long categoryId){
        var product = productRepo.findById(productId);
        var category = categoryRepo.findById(categoryId);
        product.get().getCategories().add(category.get());
        productRepo.save(product.get());
        log.info("Updated in categories of product!");
    }
}
