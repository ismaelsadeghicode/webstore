package com.mapsa.webstore.customer.controller;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.domain.LegalCustomer;
import com.mapsa.webstore.customer.domain.RealCustomer;
import com.mapsa.webstore.customer.dto.*;
import com.mapsa.webstore.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("creation/customer")
public class CustomerCreationController {
    @GetMapping
    public String hello(){
        return "hello";
    }
    @Autowired
    private CustomerService customerService;

    @PostMapping("create/legalcustomer")
    public LegalCustomer createLegalCustomer (@RequestBody LegalCustomerCreationDto legalCustomerCreationDto){
        CustomerDto customer = new CustomerDto()
                .setCode(legalCustomerCreationDto.getCode())
                .setNationalCode(legalCustomerCreationDto.getNationalCode())
                .setType(legalCustomerCreationDto.getType());
        LegalCustomerDto legalCustomerDto = new LegalCustomerDto()
                .setEconomicCode(legalCustomerCreationDto.getEconomicCode())
                .setEmailAddress(legalCustomerCreationDto.getEmailAddress())
                .setNameEn(legalCustomerCreationDto.getNameEn())
                .setNameFa(legalCustomerCreationDto.getNameFa())
                .setPhoneNumber(legalCustomerCreationDto.getPhoneNumber())
                .setWebsite(legalCustomerCreationDto.getWebsite());
        return customerService.createLegalCustomer(customer,legalCustomerDto);
    }

    @PostMapping("create/realcustomer")
    public RealCustomer createRealCustomer (@RequestBody RealCustomerCreationDto realCustomerCreationDto){
        CustomerDto customer = new CustomerDto()
                .setCode(realCustomerCreationDto.getCode())
                .setNationalCode(realCustomerCreationDto.getNationalCode())
                .setType(realCustomerCreationDto.getType());
        RealCustomerDto realCustomerDto = new RealCustomerDto()
                .setBirthDate(realCustomerCreationDto.getBirthDate())
                .setEmailAddress(realCustomerCreationDto.getEmailAddress())
                .setFirstname(realCustomerCreationDto.getFirstname())
                .setLastname(realCustomerCreationDto.getLastname())
                .setGender(realCustomerCreationDto.getGender())
                .setPhoneNumber(realCustomerCreationDto.getPhoneNumber());
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
