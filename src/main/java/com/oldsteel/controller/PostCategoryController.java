package com.oldsteel.controller;

import com.oldsteel.dto.request.PostCategoryRequestDto;
import com.oldsteel.entity.PostCategory;
import com.oldsteel.service.PostCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post-category")
@RequiredArgsConstructor
@Slf4j
public class PostCategoryController {

    private final PostCategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(@RequestBody PostCategoryRequestDto categoryRequest){
        var postCategory = categoryService
                .createPostCategory(PostCategory.saveFrom(categoryRequest));
        return new ResponseEntity<>(postCategory, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllPostCategories(){
        var categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


}
