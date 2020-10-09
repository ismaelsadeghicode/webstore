package com.mapsa.webstore.customer.service;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.domain.LegalCustomer;
import com.mapsa.webstore.customer.domain.RealCustomer;
import com.mapsa.webstore.customer.dto.CustomerDto;
import com.mapsa.webstore.customer.dto.CustomerUpdateDto;
import com.mapsa.webstore.customer.dto.LegalCustomerDto;
import com.mapsa.webstore.customer.dto.RealCustomerDto;
import com.mapsa.webstore.customer.repository.CustomerRepository;
import com.mapsa.webstore.customer.repository.LegalCustomerRepository;
import com.mapsa.webstore.customer.repository.RealCustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LegalCustomerRepository legalCustomerRepository;
    @Autowired
    private RealCustomerRepository realCustomerRepository;

    private ModelMapper mp = new ModelMapper();
    public RealCustomer createRealCustomer(CustomerDto customerDto, RealCustomerDto realCustomerDto){
        Customer customer = mp.map(customerDto, Customer.class);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZoneId localtime = zonedDateTime.getZone();
        customer.setZoneTime(localtime);
        RealCustomer realCustomer = mp.map(realCustomerDto,RealCustomer.class);
        realCustomer.setCustomer(customer);
        return realCustomerRepository.save(realCustomer);
    }
    public LegalCustomer createLegalCustomer(CustomerDto customerDto, LegalCustomerDto legalCustomerDto){
        Customer customer = mp.map(customerDto, Customer.class);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZoneId localtime = zonedDateTime.getZone();
        customer.setZoneTime(localtime);
        LegalCustomer legalCustomer = mp.map(legalCustomerDto,LegalCustomer.class);
        legalCustomer.setCustomer(customer);
        return legalCustomerRepository.save(legalCustomer);
    }
    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }
    public Customer findByCodeContaining (Long code){
        return customerRepository.findByCodeContaining(code);
    }
    public List<Customer> findByTypeContaining(String type){
        return customerRepository.findByTypeContaining(type);
    }
    public Customer findByNationalCodeContaining(Long nationalCode){
        return customerRepository.findByNationalCodeContaining(nationalCode);
    }

    public Customer update(CustomerUpdateDto customerDto, Optional<Customer> byId1) {
        Customer byId = mp.map(byId1, Customer.class);
        if (!byId.getRemark().equals("DELETED")){
        byId.setZoneTime(customerDto.getZoneTime());
        byId.setCode(customerDto.getCode());
        byId.setNationalCode(customerDto.getNationalCode());
        byId.setType(customerDto.getType());
        return customerRepository.save(byId);}
        else return new Customer();
    }

    public void delete(Optional<Customer> customer){
        Customer byId = mp.map(customer, Customer.class);
        byId.setRemark("DELETED");
        customerRepository.save(byId);
    }
}
