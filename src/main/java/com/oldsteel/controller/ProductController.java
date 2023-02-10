package com.oldsteel.controller;

import com.oldsteel.dto.request.ProductRequestDto;
import com.oldsteel.dto.response.ProductResponseDto;
import com.oldsteel.entity.Product;
import com.oldsteel.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequestDto productDto){
        var product = productService.saveProduct(Product.saveFrom(productDto));
        log.info(product.getProductName());
        return new ResponseEntity<>("Product saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProduct(){
        var productResponse = new ProductResponseDto();
        var products = productService.getAllProducts();
        for(Product product : products){
            productResponse = ProductResponseDto.dataFrom(product);
        }
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
