package com.oldsteel.dto.response;

import com.oldsteel.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductResponseDto {

    public String productName;
    public BigDecimal productPrice;
    public int stocks;

    public static ProductResponseDto dataFrom(Product product){
        var productResponse = new ProductResponseDto();
        productResponse.setProductName(product.getProductName());
        productResponse.setProductPrice(product.getProductPrice());
        productResponse.setStocks(productResponse.getStocks());
        return productResponse;
    }


}
