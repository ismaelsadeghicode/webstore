package com.mapsa.webstore.customer.service;

import com.mapsa.webstore.customer.domain.RealCustomer;
import com.mapsa.webstore.customer.dto.RealCustomerDto;
import com.mapsa.webstore.customer.repository.RealCustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RealCustomerService {
    @Autowired
    private RealCustomerRepository realCustomerRepository;

    private ModelMapper mp = new ModelMapper();

    public RealCustomer createRealCustomer(RealCustomerDto realCustomerDto) {
        RealCustomer customer = mp.map(realCustomerDto, RealCustomer.class);
        return realCustomerRepository.save(customer);
    }

    public Optional<RealCustomer> findById(Long id) {
        return realCustomerRepository.findById(id);
    }

    public List<RealCustomer> findByGender(String gender){
        if(gender.equals("male")) {
            return realCustomerRepository.findByGenderContaining(Boolean.TRUE);
        }else {
            return realCustomerRepository.findByGenderContaining(Boolean.FALSE);
        }
    }

    public RealCustomer findByFirstname(String firstname){
        return realCustomerRepository.findByFirstnameContaining(firstname);
    }

    public RealCustomer findByLastname(String lastname){
        return realCustomerRepository.findByLastnameContaining(lastname);
    }

    public RealCustomer findByEmail(String email){
        return realCustomerRepository.findByEmailAddressContaining(email);
    }

    public RealCustomer findByBirthDate(Date birthDate){
        return realCustomerRepository.findByBirthDateContaining(birthDate);
    }

    public RealCustomer findByPhoneNumber(String phoneNumber){
        return realCustomerRepository.findByPhoneNumberContaining(phoneNumber);
    }
}
