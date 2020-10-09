package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "HISTORY_TRANSACTION", schema = "BASICINFO")
@SequenceGenerator(
        name = "history_transaction_seq",
        sequenceName = "HISTORY_TRANSACTION_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class HistoryTransaction {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "history_transaction_seq")
    private Long id;
    @Basic
    @Column(name = "BANK_ID")
    private Long bankId;
    @Basic
    @Column(name = "WALLET_ID")
    private Long walletId;
    @Basic
    @Column(name = "CREATE_TIME")
    private Timestamp createTime;
    @Basic
    @Column(name = "IS_DONE")
    private String isDone;


}
