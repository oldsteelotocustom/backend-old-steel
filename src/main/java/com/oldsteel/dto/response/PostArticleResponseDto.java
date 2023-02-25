package com.oldsteel.dto.response;

import com.oldsteel.entity.PostArticle;
import com.oldsteel.entity.PostCategory;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@Getter @Setter @ToString
public class PostArticleResponseDto {
    private String title;
    private String body;
    private String author;
    private Date creationDate;
    private List<String> categories = new ArrayList<>();

    public static PostArticleResponseDto dataFrom(PostArticle postArticle){
        var postResponse = new PostArticleResponseDto();
        postResponse.setTitle(postArticle.getTitle());
        postResponse.setBody(postArticle.getBody());
        postResponse.setAuthor(postArticle.getAuthor());
        postResponse.setCreationDate(postArticle.getCreationDate());
        postResponse.setCategories(postArticle.getPostCategories()
                        .stream().map(PostCategory::getCategoryName)
                        .collect(Collectors.toList()));
        return postResponse;
    }

}
