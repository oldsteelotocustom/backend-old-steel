package com.oldsteel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.oldsteel.dto.request.PostCategoryRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post_category")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PostCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;

    @JsonManagedReference
    @ManyToMany(mappedBy = "postCategories",
            cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<PostArticle> postArticles = new HashSet<>();

    public static PostCategory saveFrom(PostCategoryRequestDto categoryRequest){
        var postCategory = new PostCategory();
        postCategory.setCategoryName(categoryRequest.getCategoryName());
        return postCategory;
    }
}
