package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "HISTORY_TRANSACTION", schema = "BASICINFO", catalog = "")
@SequenceGenerator(
        name = "history_transaction_seq",
        sequenceName = "HISTORY_TRANSACTION_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class HistoryTransaction {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "history_transaction_seq")
    private long id;
    @Basic
    @Column(name = "CREATE_TIME")
    private Timestamp createTime;
    @Basic
    @Column(name = "IS_DONE")
    private String isDone;
    @ManyToOne
    @JoinColumn(name = "BANK_ID", referencedColumnName = "ID", nullable = false)
    private Bank bankByBankId;
    @ManyToOne
    @JoinColumn(name = "WALLET_ID", referencedColumnName = "ID")
    private Wallet walletByWalletId;

}
