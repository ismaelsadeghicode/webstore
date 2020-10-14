package com.mapsa.webstore.product.service;

import com.mapsa.webstore.product.domain.Cart;
import com.mapsa.webstore.product.domain.OrderStatus;
import com.mapsa.webstore.product.domain.OrderTbl;
import com.mapsa.webstore.product.domain.User;
import com.mapsa.webstore.product.repository.OrderRepository;
import com.mapsa.webstore.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserService userService;
    private final OrderRepository orderRepository;
    private final CartService cartService;

    Cart cart= new Cart();
    public OrderTbl addProduct(Long productId) throws Exception {

        System.out.println("addProduct");
        OrderTbl orderTbl = orderRepository.findByUserAndStatus(userService.getCurrentUser(), OrderStatus.open);
        System.out.println("addProduct22222222222222222222");
        if (orderTbl !=null){
            System.out.println("addProductTocartfffffffffffffffffffffffff3333333");
            Cart temp=orderTbl.getCart();
            System.out.println(temp.getProducts().size()+"  product number: "+temp.getProducts().get(0).getName());
                cart =cartService.addProductTocart(temp,productId);
            System.out.println("addProductTocartfffffffffffffffffffffffff3333333444444444444444"+cart.getId());
            System.out.println("addProductTocartfffffffffffffffffffffffff3333333444444444444444"+userService.getCurrentUser().getUsername());
            orderTbl.setCart(cart)
                    ;
            System.out.println("addProduct4444444444444444");

        }else{
            System.out.println("addProductTonewCart555555555555555");
                cart = cartService.addProductTonewCart(productId);
            System.out.println("addProduct666666666666666666");
           orderTbl= new OrderTbl().setCart(cart)
                    .setStatus(OrderStatus.open)
                    .setUser(userService.getCurrentUser());
        }
        System.out.println(userService.getCurrentUser().getUsername());

        orderRepository.save(orderTbl);
        return orderTbl;
    }

    public List<OrderTbl> findAll() {
        return orderRepository.findAllByUser(userService.getCurrentUser());
    }

    public List<OrderTbl> closeOrder() {
        OrderTbl orderTbl=orderRepository.findByUserAndStatus(userService.getCurrentUser(),OrderStatus.open);
        if (orderTbl!=null) {
            orderTbl.setStatus(OrderStatus.close);
            orderRepository.save(orderTbl);
        }
        return findAll();
    }
}
