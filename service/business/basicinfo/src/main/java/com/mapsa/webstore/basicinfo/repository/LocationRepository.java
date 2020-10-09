package com.mapsa.webstore.basicinfo.repository;

import com.mapsa.webstore.basicinfo.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository  extends JpaRepository<Location,Long> {
}
