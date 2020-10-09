package com.mapsa.webstore.basicinfo.repository;

import com.mapsa.webstore.basicinfo.domain.HistoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryTransactionRepository  extends JpaRepository<HistoryTransaction,Long> {
}
