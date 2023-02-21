package com.oldsteel.dto.request;

import lombok.*;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class PostArticleRequest {

    private String title;
    private String body;
    private String author;
}
