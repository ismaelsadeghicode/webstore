package com.mapsa.webstore.product.controller;


import com.mapsa.webstore.product.domain.Product;
import com.mapsa.webstore.product.service.OrderService;
import com.mapsa.webstore.product.service.ProductsService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductsController  {
   private final ProductsService productsService;
   private final OrderService orderService;
    int i=0;

   /* @GetMapping
    @Timed(value = "productsMetric",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95, 0.99})
    public ResponseEntity<List<Product>> products(){

        System.out.println(i++);
        return ResponseEntity.ok(productsService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> product(@PathVariable  Long id) throws Exception {
         return  productsService.findById(id);
    }
    @GetMapping("sout")
    private String sout(){
        System.out.println(i++);
        return "ok";
    }*/


    @GetMapping
    @Timed(value = "productsMetric",histogram = true,extraTags = {"version","1.0"},percentiles = {0.95, 0.99})
    public String products(Model model){
        List<Product> products=productsService.findAll();
        model.addAttribute("products",products);
        System.out.println(i++);
        return "products";
    }
    @GetMapping("/{id}")
    public String buy(@PathVariable  Long id) throws Exception {
          orderService.addProduct(id);
          return "success";
    }
}
