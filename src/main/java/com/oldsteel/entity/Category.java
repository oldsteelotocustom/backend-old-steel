package com.oldsteel.entity;

import com.oldsteel.dto.request.CategoryRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String categoryName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "categories_tbl",
            joinColumns = { @JoinColumn(name = "category_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") })
    private List<Product> products = new ArrayList<>();


    public static Category saveFrom(CategoryRequestDto categoryDto){
        var category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        return category;
    }
}
