package com.mapsa.webstore.customer.controller;

import com.mapsa.webstore.customer.domain.RealCustomer;
import com.mapsa.webstore.customer.dto.RealCustomerDto;
import com.mapsa.webstore.customer.dto.RealCustomerUpdateDto;
import com.mapsa.webstore.customer.service.RealCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("creation/realCustomer")
public class RealCustomerCreationController {
    @Autowired
    private RealCustomerService realCustomerService;

    @PostMapping
    public RealCustomer createRealCustomer(@RequestBody RealCustomerDto realCustomerDto){
        return realCustomerService.createRealCustomer(realCustomerDto);
    }
    @PostMapping
    public RealCustomer updateCustomer(@RequestBody RealCustomerUpdateDto realCustomerDto, @RequestBody Long id){
        Optional<RealCustomer> byId = realCustomerService.findById(id);
        return realCustomerService.update(realCustomerDto,byId);
    }

    @PostMapping
    public void deleteCustomer(@RequestBody RealCustomerDto realCustomerDto, @RequestBody Long id){
        Optional<RealCustomer> byId = realCustomerService.findById(id);
        realCustomerService.delete(byId);
    }
}