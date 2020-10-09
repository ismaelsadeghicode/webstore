package com.mapsa.webstore.customer.service;

import com.mapsa.webstore.customer.domain.Customer;
import com.mapsa.webstore.customer.domain.LegalCustomer;
import com.mapsa.webstore.customer.dto.LegalCustomerDto;
import com.mapsa.webstore.customer.dto.LegalCustomerUpdateDto;
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

    public LegalCustomer update(LegalCustomerUpdateDto legalCustomerDto, Optional<LegalCustomer> byId1) {
        LegalCustomer byId = mp.map(byId1, LegalCustomer.class);
        if (!byId.getStatus().equals("DELETED")){
            byId.setEconomicCode(legalCustomerDto.getEconomicCode());
            byId.setEmailAddress(legalCustomerDto.getEmailAddress());
            byId.setNameEn(legalCustomerDto.getNameEn());
            byId.setNameFa(legalCustomerDto.getNameFa());
            byId.setPhoneNumber(legalCustomerDto.getPhoneNumber());
            byId.setWebsite(legalCustomerDto.getWebsite());
            return legalCustomerRepository.save(byId);}
        else return new LegalCustomer();
    }

    public void delete(Optional<LegalCustomer> customer) {
        LegalCustomer byId = mp.map(customer, LegalCustomer.class);
        byId.setStatus("DELETED");
        legalCustomerRepository.save(byId);
    }
}
