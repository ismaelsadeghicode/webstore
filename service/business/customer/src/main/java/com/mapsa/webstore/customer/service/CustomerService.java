package com.mapsa.webstore.customer.service;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.dto.CustomerDto;
import com.mapsa.webstore.customer.dto.CustomerUpdateDto;
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

    public Customer update(CustomerUpdateDto customerDto, Optional<Customer> byId1) {
        Customer byId = mp.map(byId1, Customer.class);
        if (!byId.getRemark().equals("DELETED")){
        byId.setInsertLocalTime(customerDto.getInsertLocalTime());
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
