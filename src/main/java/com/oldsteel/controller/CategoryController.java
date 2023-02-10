package com.oldsteel.controller;

import com.oldsteel.dto.request.CategoryRequestDto;
import com.oldsteel.entity.Category;
import com.oldsteel.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryRequestDto categoryDto){
        categoryService.createCategory(Category.saveFrom(categoryDto));
        return new ResponseEntity<>("Category saved successfully", HttpStatus.CREATED);
    }
}
