package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@SequenceGenerator(
        name = "province_seq",
        sequenceName = "PROVINCE_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class Province {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "province_seq")
    private Long id;
    @Basic
    @Column(name = "COUNTRY_ID")
    private Long countryId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CODE")
    private String code;
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
