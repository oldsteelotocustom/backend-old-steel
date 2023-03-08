package com.oldsteel.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.oldsteel.dto.request.CategoryRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String categoryName;

    @JsonManagedReference
    @ManyToMany(mappedBy = "productCategories",
            cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

    public static ProductCategory saveFrom(CategoryRequestDto categoryDto){
        var category = new ProductCategory();
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }
}
