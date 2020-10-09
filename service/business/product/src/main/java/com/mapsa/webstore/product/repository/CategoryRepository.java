package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
