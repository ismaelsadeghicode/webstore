package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRipository extends JpaRepository<User,Long> {
}
