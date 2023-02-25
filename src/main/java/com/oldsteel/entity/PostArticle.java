package com.oldsteel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.oldsteel.dto.request.PostArticleRequest;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Table(name = "post")
public class PostArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    @Column(name = "body_article")
    // columnDefinition = "TEXT", length = 2000)
    private String body;
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    public static PostArticle saveFrom(PostArticleRequest postRequest){
        var post = new PostArticle();
        post.setTitle(postRequest.getTitle());
        post.setBody(postRequest.getBody());
        return post;
    }

    @JsonBackReference
    @ManyToMany (fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST})
    @JoinTable(name = "post_categories_tbl",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "post_category_id"))
    private Set<PostCategory> postCategories = new HashSet<>();



}
