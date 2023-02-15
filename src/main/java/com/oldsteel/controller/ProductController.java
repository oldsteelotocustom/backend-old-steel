package com.oldsteel.controller;

import com.oldsteel.dto.request.ProductRequestDto;
import com.oldsteel.dto.request.ProductToCategoryRequestDto;
import com.oldsteel.dto.response.ProductResponseDto;
import com.oldsteel.entity.Product;
import com.oldsteel.repository.ProductRepository;
import com.oldsteel.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductRepository productRepository;

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductRequestDto productDto){
        var product = productService.saveProduct(Product.saveFrom(productDto));
        log.info(product.getProductName());
        log.info(product.getProductCode());
        return new ResponseEntity<>("Product saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProduct(){
        var products = productService.getAllProducts();
        if(products.isEmpty()){
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        List<ProductResponseDto> productResponsesList = new ArrayList<>();
        for(Product product : products){
            productResponsesList.add(ProductResponseDto.dataFrom(product));
        }
        return new ResponseEntity<>(productResponsesList, HttpStatus.OK);
    }

    @PostMapping("/add-category")
    public ResponseEntity<?> insertProductToCategory(@RequestBody ProductToCategoryRequestDto toCategoryRequestDto){
        productService.insertBookToCategory(toCategoryRequestDto.getProductId(), toCategoryRequestDto.getCategoryId());
        log.info("saved data successfully");
        return new ResponseEntity<>("product has been add", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getProductById(@RequestParam Long productId){
        var product = productService.findProductById(productId);
        if(product.isEmpty()){
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        var productResponse = ProductResponseDto.dataFrom(product.get());
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping("/code")
    public ResponseEntity<?> getProductByCode(@RequestParam String productCode){
        var product = productService.findProductByCode(productCode);
        if(product == null){
            return new ResponseEntity<>("Product not found....", HttpStatus.NOT_FOUND);
        }
        var productResponse = ProductResponseDto.dataFrom(product);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
