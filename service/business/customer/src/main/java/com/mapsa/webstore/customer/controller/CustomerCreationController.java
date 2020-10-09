package com.mapsa.webstore.customer.controller;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.domain.LegalCustomer;
import com.mapsa.webstore.customer.domain.RealCustomer;
import com.mapsa.webstore.customer.dto.CustomerDto;
import com.mapsa.webstore.customer.dto.CustomerUpdateDto;
import com.mapsa.webstore.customer.dto.LegalCustomerDto;
import com.mapsa.webstore.customer.dto.RealCustomerDto;
import com.mapsa.webstore.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("creation/customer")
public class CustomerCreationController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("create/legalcustomer")
    public LegalCustomer createLegalCustomer (@RequestBody CustomerDto customer, @RequestBody LegalCustomerDto legalCustomerDto){
        return customerService.createLegalCustomer(customer,legalCustomerDto);
    }
    @PostMapping("create/realcustomer")
    public RealCustomer createRealCustomer (@RequestBody CustomerDto customer, @RequestBody RealCustomerDto realCustomerDto){
        return customerService.createRealCustomer(customer,realCustomerDto);
    }

    @PostMapping("update")
    public Customer updateCustomer(@RequestBody CustomerUpdateDto customerDto, @RequestBody Long id){
        Optional<Customer> byId = customerService.findById(id);
        return customerService.update(customerDto,byId);
    }

    @PostMapping("delete")
    public void deleteCustomer(@RequestBody CustomerDto customerDto, @RequestBody Long id){
        Optional<Customer> byId = customerService.findById(id);
        customerService.delete(byId);
    }
}
