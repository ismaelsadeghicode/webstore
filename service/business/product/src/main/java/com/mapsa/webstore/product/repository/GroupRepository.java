
package com.mapsa.webstore.product.repository;
import com.mapsa.webstore.product.domain.GroupTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupTbl,Long> {
}

