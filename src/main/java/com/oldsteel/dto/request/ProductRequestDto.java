package com.oldsteel.dto.request;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
public class ProductRequestDto {

    private String productName;
    private BigDecimal productPrice;
    private int stocks;
}
