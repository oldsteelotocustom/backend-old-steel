package com.oldsteel.controller;

import com.oldsteel.dto.request.ProductRequestDto;
import com.oldsteel.entity.Product;
import com.oldsteel.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequestDto productDto){
//        var product = new Product();
//        product.setProductName(productDto.getProductName());
//        product.setProductPrice(productDto.getProductPrice());
        productService.saveProduct(Product.saveFrom(productDto));
        return new ResponseEntity<>("Product saved successfully", HttpStatus.CREATED);
    }
}
