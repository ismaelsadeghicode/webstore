package com.mapsa.webstore.basicinfo.repository;

import com.mapsa.webstore.basicinfo.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository  extends JpaRepository<Province,Long> {
}
