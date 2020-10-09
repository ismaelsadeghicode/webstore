package com.mapsa.webstore.basicinfo.repository;

import com.mapsa.webstore.basicinfo.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository  extends JpaRepository<Wallet,Long> {
}
