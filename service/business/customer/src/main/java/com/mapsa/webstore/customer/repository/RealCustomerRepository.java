package com.mapsa.webstore.customer.repository;

import com.mapsa.webstore.customer.domain.RealCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RealCustomerController extends JpaRepository <RealCustomer,Long> {
    public RealCustomer findByFirstnameContaining(String firstname);
    public RealCustomer findByLastnameContaining(String lastname);
    public RealCustomer findByEmailAddressContaining(String email);
    public RealCustomer findByPhoneNumberContaining(String phoneNumber);
    public RealCustomer findByBirthDateContaining(Date birthDate);
}
