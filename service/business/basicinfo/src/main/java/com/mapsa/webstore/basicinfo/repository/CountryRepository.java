package com.mapsa.webstore.basicinfo.repository;

import com.mapsa.webstore.basicinfo.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
