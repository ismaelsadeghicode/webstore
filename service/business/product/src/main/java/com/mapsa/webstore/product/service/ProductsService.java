
package com.mapsa.webstore.product.service;


import com.mapsa.webstore.product.domain.Product;
import com.mapsa.webstore.product.repository.CartRepository;
import com.mapsa.webstore.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;


    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public ResponseEntity<Product> findById(Long id) throws Exception {
           return ResponseEntity.ok(productRepository.findById(id).orElseThrow(()->new Exception("jfjfjj")));
    }
    public ResponseEntity<Product> addProductToCart(Long id){
       Product product=new Product();


        return ResponseEntity.ok(product);
    }

}

