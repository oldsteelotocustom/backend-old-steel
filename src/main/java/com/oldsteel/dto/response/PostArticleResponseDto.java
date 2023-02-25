package com.oldsteel.dto.response;

import com.oldsteel.entity.PostArticle;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class PostArticleResponseDto {
    private String title;
    private String body;
    private String author;
    private Date creationDate;

    public static PostArticleResponseDto dataFrom(PostArticle postArticle){
        var postResponse = new PostArticleResponseDto();
        postResponse.setTitle(postArticle.getTitle());
        postResponse.setBody(postArticle.getBody());
        postResponse.setAuthor(postArticle.getAuthor());
        postResponse.setCreationDate(postArticle.getCreationDate());
        return postResponse;
    }

}
