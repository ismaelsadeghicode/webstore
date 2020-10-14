
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



    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id)  {

           Product product= productRepository.findById(id).orElseThrow(()->new IllegalStateException());

           return product;
    }




}

