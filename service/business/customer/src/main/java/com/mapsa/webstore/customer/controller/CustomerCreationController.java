package com.mapsa.webstore.customer.controller;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.dto.CustomerDto;
import com.mapsa.webstore.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("creation/customer")
public class CustomerCreationController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public Customer createCustomer (@RequestBody CustomerDto customer){
        return customerService.createCustomer(customer);
    }
}
