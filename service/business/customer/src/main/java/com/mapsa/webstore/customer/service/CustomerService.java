package com.mapsa.webstore.customer.service;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.dto.CustomerDto;
import com.mapsa.webstore.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    private ModelMapper mp = new ModelMapper();
    public Customer createCustomer(CustomerDto customerDto){
        Customer customer = mp.map(customerDto, Customer.class);
        return customerRepository.save(customer);
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
}
