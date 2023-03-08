package com.oldsteel.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CategoryRequestDto {

    @NotBlank(message = "Product category name cannot be blank")
    @Size(min = 20, message = "The length must be at least 20 characters")
    private String categoryName;
}
