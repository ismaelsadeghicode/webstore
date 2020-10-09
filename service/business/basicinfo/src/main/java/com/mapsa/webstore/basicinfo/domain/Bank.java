package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@SequenceGenerator(
        name = "bank_seq",
        sequenceName = "BANK_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class Bank {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bank_seq")
    private long id;
    @Basic
    @Column(name = "USER_ID")
    private long userId;
    @Basic
    @Column(name = "CARD_NO")
    private Long cardNo;
    @Basic
    @Column(name = "LOCK_VERSION")
    private Long lockVersion;

}
