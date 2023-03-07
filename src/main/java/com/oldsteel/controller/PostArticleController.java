package com.oldsteel.controller;

import com.oldsteel.dto.request.PostArticleRequest;
import com.oldsteel.dto.response.PostArticleResponseDto;
import com.oldsteel.entity.PostArticle;
import com.oldsteel.helper.ErrorMessages;
import com.oldsteel.service.PostArticleService;
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
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
@Slf4j
public class PostArticleController {

    private final PostArticleService postService;

    @PostMapping("/create")
    public ResponseEntity<?> createArticle(@RequestBody @Valid PostArticleRequest postRequest, Errors errors){
        if(errors.hasErrors()){
            log.info("There's some error: {}", errors.getAllErrors());
            return new ResponseEntity<>(ErrorMessages.throwError(errors), HttpStatus.BAD_REQUEST);
        }
        postService.savePost(PostArticle.saveFrom(postRequest));
        return new ResponseEntity<>("Article created and saved", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPost(){
        var post = postService.getAllPost();
        List<PostArticleResponseDto> postResponses = new ArrayList<>();
        for(PostArticle postArticle : post){
            postResponses.add(PostArticleResponseDto.dataFrom(postArticle));
        }
        if(postResponses.isEmpty()){
            log.info("Data is empty{} ", postResponses);
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(postResponses, HttpStatus.OK);
    }

    @GetMapping("/id")
    @ResponseBody
    public ResponseEntity<?> findPostById(@RequestParam Long articleId){
        var post = postService.findById(articleId);
        if(post.isEmpty()){
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(PostArticleResponseDto.dataFrom(post.get()),
                HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> findPostWithDate(){
        var post = postService.getAllPostBySortingCreationDate();
        if(post.isEmpty()){
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable("id") Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Delete Successes", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePost(@RequestParam Long postId, @RequestBody @Valid PostArticleRequest postRequest, Errors errors){
        var post = postService.findById(postId);
        if(post.isEmpty()){
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        }
        if(errors.hasErrors()){
            return new ResponseEntity<>(ErrorMessages.throwError(errors), HttpStatus.BAD_REQUEST);
        }
        var postArticle = postService.updatePost(postId, postRequest.getTitle(), postRequest.getBody());
        return new ResponseEntity<>("Post updated and saved", HttpStatus.OK);
    }



}
