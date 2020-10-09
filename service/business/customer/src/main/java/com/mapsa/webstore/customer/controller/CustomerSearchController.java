package com.mapsa.webstore.customer.controller;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("search/customer")
public class CustomerSearchController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("by/id/{id}")
    public Optional<Customer> findById(@PathVariable Long id){
        return customerService.findById(id);
    }
    @GetMapping("by/code/{code}")
    public Customer findByCode(@PathVariable Long code){
        return customerService.findByCodeContaining(code);
    }

    @GetMapping("by/type/{type}")
    public List<Customer> findByType(@PathVariable String type){
        return customerService.findByTypeContaining(type);
    }

    @GetMapping("by/nationalcode/{nationalcode}")
    public Customer findByNationalCode(@PathVariable Long nationalcode){
        return customerService.findByNationalCodeContaining(nationalcode);
    }
}
