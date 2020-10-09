package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(
        name = "wallet_seq",
        sequenceName = "WALLET_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class Wallet {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "wallet_seq")
    private Long id;
    @Basic
    @Column(name = "BANK_ID")
    private Long bankId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "AMOUNT")
    private long amount;
    @Basic
    @Column(name = "INN")
    private String inn;
    @Basic
    @Column(name = "REMARKS")
    private String remarks;
    @Basic
    @Column(name = "LOCK_VERSION")
    private long lockVersion;

}
