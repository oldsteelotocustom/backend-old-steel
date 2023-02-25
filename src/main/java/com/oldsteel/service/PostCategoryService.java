package com.oldsteel.service;

import com.oldsteel.entity.PostCategory;
import com.oldsteel.repository.PostCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostCategoryService {

    private final PostCategoryRepository postCategoryRepository;

    public PostCategory createPostCategory(PostCategory postCategory){
        return postCategoryRepository.save(postCategory);
    }

    public List<PostCategory> getAllCategories(){
        return postCategoryRepository.findAll();
    }
}
