package com.oldsteel.repository;

import com.oldsteel.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByProductCode(String productCode);

    @Query("SELECT p FROM Product p WHERE p.productCode = :productCode")
    Product findCode(@Param("productCode") String code);
}
