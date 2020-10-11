
package com.mapsa.webstore.product.repository;

import com.mapsa.webstore.product.domain.Factor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FactorRepository extends JpaRepository<Factor,Long>{
}

