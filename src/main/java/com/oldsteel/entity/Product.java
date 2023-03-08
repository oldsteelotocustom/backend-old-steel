package com.oldsteel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.oldsteel.dto.request.ProductRequestDto;
import com.oldsteel.helper.BigDecimalConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productCode;

    private String productName;

    @Convert(converter = BigDecimalConverter.class)
    @Column(name = "price", nullable = false)
    private BigDecimal productPrice;
    private boolean availability;
    private int stocks;

    @JsonBackReference
    @ManyToMany (fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST})
    @JoinTable(name = "categories_product_tbl",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<ProductCategory> productCategories = new HashSet<>();

    public static Product saveFrom(ProductRequestDto productDto){
        var product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setStocks(productDto.getStocks());
        return product;
    }
}
