package com.oldsteel.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class PostArticleRequest {

    @NotBlank(message = "Title name must be written")
    @Size(min = 20, max = 100, message = "Min title must be 20 characters")
    private String title;

    @NotBlank(message = "Body of article or post cannot be blank")
    @Size(min = 500, max = 2000, message = "Min characters for body of post must be 500")
    private String body;
}
