package com.mapsa.webstore.basicinfo.repository;

import com.mapsa.webstore.basicinfo.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long>{
}
