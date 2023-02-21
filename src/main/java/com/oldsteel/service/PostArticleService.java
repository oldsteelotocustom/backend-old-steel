package com.oldsteel.service;

import com.oldsteel.entity.PostArticle;
import com.oldsteel.repository.PostArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostArticleService {

    private final PostArticleRepository postRepository;

    public PostArticle savePost(PostArticle postArticle){
        postArticle.setAuthor("Admin");
        return postRepository.save(postArticle);
    }

    public List<PostArticle> getAllPostBySorting(){
        //return postRepository.findPostArticleOrderByCreationDate();
        return postRepository.findAll(Sort.by(Sort.Direction.ASC, "creationDate"));
    }

    public List<PostArticle> getAllPost(){
        return postRepository.findAll();
    }

}
