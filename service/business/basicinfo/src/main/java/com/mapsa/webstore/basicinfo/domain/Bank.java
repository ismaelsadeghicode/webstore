package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "bank_seq",
        sequenceName = "BANK_SEQ",
        allocationSize = 1000,initialValue = 10000
)
@Data
public class Bank {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bank_seq")
    private Long id;
    @Basic
    @Column(name = "USER_ID")
    private Long userId;
    @Basic
    @Column(name = "CARD_NO")
    private long cardNo;
    @Basic
    @Column(name = "LOCK_VERSION")
    private long lockVersion;


}
