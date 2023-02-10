package com.oldsteel.entity;

import com.oldsteel.dto.request.ProductRequestDto;
import com.oldsteel.helper.BigDecimalConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    @Convert(converter = BigDecimalConverter.class)
    @Column(name = "price", nullable = false)
    private BigDecimal productPrice;
    private boolean availability;

    public static Product saveFrom(ProductRequestDto productDto){
        var product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        return product;
    }
}
