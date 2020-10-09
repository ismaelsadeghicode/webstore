package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@SequenceGenerator(
        name = "wallet_seq",
        sequenceName = "WALLET_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class Wallet {
    private long id;
    private String name;
    private Long amount;
    private String inn;
    private String remarks;
    private Long lockVersion;
    private Bank bankByBankId;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "wallet_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "INN")
    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "REMARKS")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "LOCK_VERSION")
    public Long getLockVersion() {
        return lockVersion;
    }

    public void setLockVersion(Long lockVersion) {
        this.lockVersion = lockVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (id != wallet.id) return false;
        if (name != null ? !name.equals(wallet.name) : wallet.name != null) return false;
        if (amount != null ? !amount.equals(wallet.amount) : wallet.amount != null) return false;
        if (inn != null ? !inn.equals(wallet.inn) : wallet.inn != null) return false;
        if (remarks != null ? !remarks.equals(wallet.remarks) : wallet.remarks != null) return false;
        if (lockVersion != null ? !lockVersion.equals(wallet.lockVersion) : wallet.lockVersion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (inn != null ? inn.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        result = 31 * result + (lockVersion != null ? lockVersion.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BANK_ID", referencedColumnName = "ID", nullable = false)
    public Bank getBankByBankId() {
        return bankByBankId;
    }

    public void setBankByBankId(Bank bankByBankId) {
        this.bankByBankId = bankByBankId;
    }
}
