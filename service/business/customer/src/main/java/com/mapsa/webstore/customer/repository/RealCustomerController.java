package com.mapsa.webstore.customer.repository;

import com.mapsa.webstore.customer.domain.RealCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealCustomerController extends JpaRepository <RealCustomer,Long> {
}
