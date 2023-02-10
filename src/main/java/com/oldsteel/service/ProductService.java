package com.oldsteel.service;

import com.oldsteel.entity.Product;
import com.oldsteel.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;

    public Product saveProduct(Product product){
        product.setAvailability(true);
        return productRepo.save(product);
    }
}
