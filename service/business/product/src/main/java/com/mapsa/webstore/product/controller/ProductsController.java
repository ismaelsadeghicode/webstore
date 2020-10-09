package com.mapsa.webstore.product.controller;

import com.mapsa.webstore.product.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController  {
    private final
    @GetMapping
    public ResponseEntity<List<Product>> products(){

    }
}
