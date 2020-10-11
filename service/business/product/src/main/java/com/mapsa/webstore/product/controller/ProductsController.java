package com.mapsa.webstore.product.controller;


import com.mapsa.webstore.product.domain.Product;
import com.mapsa.webstore.product.service.ProductsService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductsController  {
   private final ProductsService productsService;
    @GetMapping
    @Timed(value = "productsMetric",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95, 0.99})
    public ResponseEntity<List<Product>> products(){
        return ResponseEntity.ok(productsService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> product(@PathVariable  Long id) throws Exception {
         return  productsService.findById(id);
    }
    @GetMapping("sout")
    private String sout(){
        return "ok";
    }
}
