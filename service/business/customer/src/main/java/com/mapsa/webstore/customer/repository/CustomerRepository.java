package com.mapsa.webstore.customer.repository;

import com.mapsa.webstore.customer.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer,Long> {
    Customer findByCodeContaining(Long code);
    List<Customer> findByTypeContaining(String type);
    Customer findByNationalCodeContaining(Long nationalCode);
}
