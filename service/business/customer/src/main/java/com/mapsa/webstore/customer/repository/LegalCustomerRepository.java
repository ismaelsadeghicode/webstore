package com.mapsa.webstore.customer.repository;

import com.mapsa.webstore.customer.domain.LegalCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalCustomerRepository extends JpaRepository <LegalCustomer,Long> {
    LegalCustomer findByNameFaContaining(String nameFa);
    LegalCustomer findByNameEnContaining(String nameEn);
    LegalCustomer findByEconomicCodeContaining(Long code);
    LegalCustomer findByPhoneNumberContaining(String phoneNumber);
    LegalCustomer findByEmailAddressContaining(String email);
}
