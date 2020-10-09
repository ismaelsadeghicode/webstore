package com.mapsa.webstore.customer.controller;

import com.mapsa.webstore.customer.domain.RealCustomer;
import com.mapsa.webstore.customer.service.RealCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("search/realcustomer")
public class RealCustomerSearchController {
    @Autowired
    private RealCustomerService realCustomerService;

    @GetMapping("by/id/{id}")
    public Optional<RealCustomer> findById(@PathVariable Long id){
        return realCustomerService.findById(id);
    }

    @GetMapping("by/gender/{gender}")
    public List<RealCustomer> findByGender(@PathVariable String gender){
        return realCustomerService.findByGender(gender);
    }
    @GetMapping("by/phonenumber/{phonenumber}")
    public RealCustomer findByPhoneNumber(@PathVariable String phonenumber){
        return realCustomerService.findByPhoneNumber(phonenumber);
    }
    @GetMapping("by/email/{email}")
    public RealCustomer findByEmail (@PathVariable String email){
        return realCustomerService.findByEmail(email);
    }
    @GetMapping("by/name/{firstname}")
    public RealCustomer findByNameFa(@PathVariable String firstname){
        return realCustomerService.findByFirstname(firstname);
    }

    @GetMapping("by/name/{lastname}")
    public RealCustomer findByNameEn(@PathVariable String lastname){
        return realCustomerService.findByLastname(lastname);
    }

    @GetMapping("by/birthdate/{birthdate}")
    public RealCustomer findByBirthdate(@PathVariable Date birthdate){
        return realCustomerService.findByBirthDate(birthdate);
    }
}
