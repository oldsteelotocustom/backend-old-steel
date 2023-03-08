package com.oldsteel.dto.response;

import com.oldsteel.entity.ProductCategory;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class ProductCategoryResponseDto {

    private String categoryName;

    public static ProductCategoryResponseDto dataFrom(ProductCategory productCategory){
        var productCategoryResponse = new ProductCategoryResponseDto();
        productCategoryResponse.setCategoryName(productCategory.getCategoryName());
        return productCategoryResponse;
    }
}
