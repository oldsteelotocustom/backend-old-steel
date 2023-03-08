package com.oldsteel.controller;

import com.oldsteel.dto.request.CategoryRequestDto;
import com.oldsteel.dto.response.ProductCategoryResponseDto;
import com.oldsteel.entity.ProductCategory;
import com.oldsteel.helper.ErrorMessages;
import com.oldsteel.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product-category")
@RequiredArgsConstructor
@Slf4j
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(@RequestBody @Valid CategoryRequestDto categoryDto, Errors errors){
        if(errors.hasErrors()){
            return new ResponseEntity<>(ErrorMessages.throwError(errors), HttpStatus.BAD_REQUEST);
        }
        var category = productCategoryService.createCategory(ProductCategory.saveFrom(categoryDto));
        return new ResponseEntity<>("Category saved successfully", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCategories(){
        var categories = productCategoryService.getAllCategories();
        if(categories.isEmpty()){
            return new ResponseEntity<>("Categories not found...", HttpStatus.NOT_FOUND);
        }
        List<ProductCategoryResponseDto> categoryResponseDto = new ArrayList<>();
        for(ProductCategory productCategory: categories){
            categoryResponseDto.add(ProductCategoryResponseDto.dataFrom(productCategory));
        }
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> findCategoryById(@RequestParam Long categoryId){
        var category = productCategoryService.findById(categoryId);
        if(category.isEmpty()){
            return new ResponseEntity<>("Product category not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ProductCategoryResponseDto.dataFrom(category.get()), HttpStatus.OK);
    }
}
