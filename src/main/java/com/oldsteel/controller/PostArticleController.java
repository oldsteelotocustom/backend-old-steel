package com.oldsteel.controller;

import com.oldsteel.dto.request.PostArticleRequest;
import com.oldsteel.entity.PostArticle;
import com.oldsteel.service.PostArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class PostArticleController {

    private final PostArticleService postService;

    @PostMapping("/create")
    public ResponseEntity<?> createArticle(@RequestBody PostArticleRequest postRequest){
        var post = new PostArticle();
        post.setBody(postRequest.getBody());
        post.setTitle(postRequest.getTitle());
        postService.savePost(post);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllPost(){
        var post = postService.getAllPost();
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}
