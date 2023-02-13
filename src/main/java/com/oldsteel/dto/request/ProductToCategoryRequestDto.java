package com.oldsteel.dto.request;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @ToString
public class ProductToCategoryRequestDto {

    private Long categoryId;
    private Long productId;
}
