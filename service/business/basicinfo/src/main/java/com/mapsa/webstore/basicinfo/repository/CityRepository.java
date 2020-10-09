package com.mapsa.webstore.basicinfo.repository;

import com.mapsa.webstore.basicinfo.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository  extends JpaRepository<City,Long> {
}
