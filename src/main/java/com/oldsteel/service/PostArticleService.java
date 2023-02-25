package com.oldsteel.service;

import com.oldsteel.entity.PostArticle;
import com.oldsteel.repository.PostArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostArticleService {

    private final PostArticleRepository postRepository;

    public PostArticle savePost(PostArticle postArticle){
        postArticle.setAuthor("Admin");
        postArticle.setCreationDate(new Date());
        return postRepository.save(postArticle);
    }

    public List<PostArticle> getAllPostBySortingCreationDate(){
        return postRepository.findAll(Sort.by(Sort.Direction.ASC, "creationDate"));
    }

    public List<PostArticle> getAllPost(){
        return postRepository.findAll();
    }

    public Optional<PostArticle> findById(Long id){
        return postRepository.findById(id);
    }

    public void deletePostById(Long id){
        postRepository.deleteById(id);
    }

    public PostArticle updatePost(Long id, String title, String body){
        var post = findById(id).orElseThrow(RuntimeException::new);
            post.setTitle(title);
            post.setBody(body);
            post.setAuthor("Admin");
            post.setCreationDate(new Date());
            return postRepository.save(post);
        }


}
