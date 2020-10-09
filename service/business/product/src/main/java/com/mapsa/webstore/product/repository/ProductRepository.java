package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByNameContaining(String name);
}
