package com.oldsteel.dto.request;

import lombok.*;

import javax.persistence.Lob;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class PostArticleRequest {

    private String title;
    private String body;
}
