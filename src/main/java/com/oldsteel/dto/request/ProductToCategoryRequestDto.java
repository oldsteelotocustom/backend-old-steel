package com.oldsteel.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class ProductToCategoryRequestDto {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("category_id")
    private Long categoryId;
}
