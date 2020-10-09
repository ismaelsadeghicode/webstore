package com.mapsa.webstore.customer.service;

import com.mapsa.webstore.customer.domain.LegalCustomer;
import com.mapsa.webstore.customer.dto.LegalCustomerDto;
import com.mapsa.webstore.customer.repository.LegalCustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LegalCustomerService {
    @Autowired
    private LegalCustomerRepository legalCustomerRepository;

    private ModelMapper mp = new ModelMapper();

    public LegalCustomer createLegalCustomer(LegalCustomerDto legalCustomerDto) {
        LegalCustomer customer = mp.map(legalCustomerDto, LegalCustomer.class);
        return legalCustomerRepository.save(customer);
    }

    public Optional<LegalCustomer> findById(Long id) {
        return legalCustomerRepository.findById(id);
    }

    public LegalCustomer findByEconomicCodeContaining(Long code) {
        return legalCustomerRepository.findByEconomicCodeContaining(code);
    }

    public LegalCustomer findByPhoneNumberContaining(String phoneNumber){
        return legalCustomerRepository.findByPhoneNumberContaining(phoneNumber);
    }

    public LegalCustomer findByEmailAddressContaining(String email){
        return legalCustomerRepository.findByEmailAddressContaining(email);
    }

    public LegalCustomer findByNameFaContaining(String nameFa){
        return legalCustomerRepository.findByNameFaContaining(nameFa);
    }

    public LegalCustomer findByNameEnContaining(String nameEn){
        return legalCustomerRepository.findByNameEnContaining(nameEn);
    }
}
