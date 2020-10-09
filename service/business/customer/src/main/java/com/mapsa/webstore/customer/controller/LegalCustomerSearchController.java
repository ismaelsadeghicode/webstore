package com.mapsa.webstore.customer.controller;


import com.mapsa.webstore.customer.domain.LegalCustomer;
import com.mapsa.webstore.customer.service.LegalCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("search/legalcustomer")
public class LegalCustomerSearchController {
    @Autowired
    private LegalCustomerService legalCustomerService;

    @GetMapping("by/id/{id}")
    public Optional<LegalCustomer> findById(@PathVariable Long id){
        return legalCustomerService.findById(id);
    }

    @GetMapping("by/economiccode/{economiccode}")
    public LegalCustomer findByCode(@PathVariable Long economiccode){
        return legalCustomerService.findByEconomicCodeContaining(economiccode);
    }
    @GetMapping("by/phonenumber/{phonenumber}")
    public LegalCustomer findByPhoneNumber(@PathVariable String phonenumber){
        return legalCustomerService.findByPhoneNumberContaining(phonenumber);
    }
    @GetMapping("by/email/{email}")
    public LegalCustomer findByEmail (@PathVariable String email){
        return legalCustomerService.findByEmailAddressContaining(email);
    }
    @GetMapping("by/name/fa/{nameFa}")
    public LegalCustomer findByNameFa(@PathVariable String nameFa){
        return legalCustomerService.findByNameFaContaining(nameFa);
    }

    @GetMapping("by/name/en/{nameEn}")
    public LegalCustomer findByNameEn(@PathVariable String nameEn){
        return legalCustomerService.findByNameEnContaining(nameEn);
    }
}
