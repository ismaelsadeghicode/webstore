
package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.OrderTbl;
import com.mapsa.webstore.product.domain.OrderTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderTbl, Long> {
    //OrderTbl findByCart(Long cartId);
}

