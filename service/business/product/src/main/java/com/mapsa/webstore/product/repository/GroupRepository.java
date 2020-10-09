package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.Factor;
import com.mapsa.webstore.product.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
