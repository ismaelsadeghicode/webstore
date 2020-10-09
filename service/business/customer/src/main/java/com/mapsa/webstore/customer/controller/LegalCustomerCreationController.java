package com.mapsa.webstore.customer.controller;

import com.mapsa.webstore.customer.domain.LegalCustomer;
import com.mapsa.webstore.customer.dto.LegalCustomerDto;
import com.mapsa.webstore.customer.service.LegalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("creation/legalCustomer")
public class LegalCustomerCreationController {
    @Autowired
    private LegalCustomerService legalCustomerService;

    @PostMapping
    public LegalCustomer createLegalCustomer(@RequestBody LegalCustomerDto legalCustomerDto){
        return legalCustomerService.createLegalCustomer(legalCustomerDto);
    }
}
