package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(
        name = "country_seq",
        sequenceName = "COUNTRY_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class Country {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "country_seq")
    private Long id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "NUMERIC_CODE")
    private String numericCode;
    @Basic
    @Column(name = "ALPHABET2_CODE")
    private String alphabet2Code;
    @Basic
    @Column(name = "ALPHABET3_CODE")
    private String alphabet3Code;
    @Basic
    @Column(name = "REMARKS")
    private String remarks;
    @Basic
    @Column(name = "LOCK_VERSION")
    private long lockVersion;


}
