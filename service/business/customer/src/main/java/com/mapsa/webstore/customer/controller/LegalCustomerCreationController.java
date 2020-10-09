package com.mapsa.webstore.customer.controller;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.domain.LegalCustomer;
import com.mapsa.webstore.customer.dto.CustomerDto;
import com.mapsa.webstore.customer.dto.LegalCustomerDto;
import com.mapsa.webstore.customer.dto.LegalCustomerUpdateDto;
import com.mapsa.webstore.customer.service.LegalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("creation/legalCustomer")
public class LegalCustomerCreationController {
    @Autowired
    private LegalCustomerService legalCustomerService;

    @PostMapping("update")
    public LegalCustomer updateCustomer(@RequestBody LegalCustomerUpdateDto legalCustomerDto, @RequestBody Long id){
        Optional<LegalCustomer> byId = legalCustomerService.findById(id);
        return legalCustomerService.update(legalCustomerDto,byId);
    }

    @PostMapping("delete")
    public void deleteCustomer(@RequestBody LegalCustomerDto legalCustomerDto, @RequestBody Long id){
        Optional<LegalCustomer> byId = legalCustomerService.findById(id);
        legalCustomerService.delete(byId);
    }
}
