
package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByNameContaining(String name);
    //Product findBy(Long groupId);
}

