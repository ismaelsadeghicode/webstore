package com.mapsa.webstore.customer.repository;

import com.mapsa.webstore.customer.domain.RealCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RealCustomerRepository extends JpaRepository <RealCustomer,Long> {
    List<RealCustomer>findByGenderContaining(Boolean gender);
    RealCustomer findByFirstnameContaining(String firstname);
    RealCustomer findByLastnameContaining(String lastname);
    RealCustomer findByEmailAddressContaining(String email);
    RealCustomer findByPhoneNumberContaining(String phoneNumber);
    RealCustomer findByBirthDateContaining(Date birthDate);
}
