package com.oldsteel.controller;

import com.oldsteel.dto.request.CategoryRequestDto;
import com.oldsteel.dto.request.ProductToCategoryRequestDto;
import com.oldsteel.entity.Category;
import com.oldsteel.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryRequestDto categoryDto){
        var category = categoryService.createCategory(Category.saveFrom(categoryDto));
        return new ResponseEntity<>("Category saved successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-product")
    public ResponseEntity<?> insertProductToCategory(@RequestBody ProductToCategoryRequestDto toCategoryRequestDto){
        if(toCategoryRequestDto.getProductId().equals(0L)){
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        } else if (toCategoryRequestDto.getCategoryId().equals(0L)) {
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
        categoryService.insertBookToCategory(toCategoryRequestDto.getCategoryId(),
                toCategoryRequestDto.getProductId());
        return new ResponseEntity<>("Category has been added to product...", HttpStatus.OK);
    }
}
