package com.mapsa.webstore.product.service;

import com.mapsa.webstore.product.domain.Cart;
import com.mapsa.webstore.product.domain.Product;
import com.mapsa.webstore.product.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {


    private final ProductsService productsService;
    private final CartRepository cartRepository;
    public Cart addProductTonewCart(Long productid) throws Exception {
        List<Product> products=new ArrayList<>();
         Cart cart=new Cart();
        System.out.println("??????????????0"+productid);
        Product product=new Product();

           product= productsService.findById(productid);

        System.out.println("??????????????1");
        products.add(product);
        System.out.println("??????????????22222222");
        cart.setProducts(products);
        System.out.println("??????????????333333333");
        System.out.println(cart.getId()+cart.getProducts().get(0).getName());
        cart= cartRepository.save(cart);
        System.out.println("??????????????4444444444444444");
        return cart;

    }
    public Cart addProductTocart(Cart cart1,Long productId) throws Exception {

        Cart cart =cartRepository.findById(cart1.getId()).orElseThrow(()-> new IllegalStateException("cart not found"));
        List<Product> products=cart.getProducts();
        Product product=productsService.findById(productId);
        products.add(product);
        cart.setProducts(products);
        cartRepository.save(cart);
        return cart;
    }
}
