
package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.OrderStatus;
import com.mapsa.webstore.product.domain.OrderTbl;
import com.mapsa.webstore.product.domain.OrderTbl;
import com.mapsa.webstore.product.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderTbl, Long> {
    //OrderTbl findByCart(Long cartId);
    OrderTbl findByUserAndStatus(User user,OrderStatus  orderStatus);
    List<OrderTbl> findAllByUser(User user);
}

