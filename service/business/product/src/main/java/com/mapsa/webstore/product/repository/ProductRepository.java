
package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.PreparedStatement;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByNameContaining(String name);
    Product findByGroup_id(Long groupId);
}

