package com.mapsa.webstore.product.service;

import com.mapsa.webstore.product.domain.Product;
import com.mapsa.webstore.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productRepository;
    public List<Product> findAll(){
        return productRepository.findAll();

    }
}
