package com.oldsteel.controller;

import com.oldsteel.dto.request.CategoryRequestDto;
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

    @GetMapping("/all")
    public ResponseEntity<?> findAllCategories(){
        var categories = categoryService.getAllCategories();
        if(categories.isEmpty()){
            return new ResponseEntity<>("Categories not found...", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> findCategoryById(@RequestParam Long categoryId){
        var category = categoryService.findById(categoryId);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
