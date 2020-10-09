package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByCart(Long cartId);
}
