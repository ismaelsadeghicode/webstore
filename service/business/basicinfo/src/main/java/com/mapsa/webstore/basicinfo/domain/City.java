package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@SequenceGenerator(
        name = "city_seq",
        sequenceName = "CITY_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class City {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "city_seq")
    private Long id;
    @Basic
    @Column(name = "PROVINCE_ID")
    private Long provinceId;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name = "CODE")
    private String code;
    @Basic
    @Column(name = "REMARKS")
    private String remarks;
    @Basic
    @Column(name = "LOCK_VERSION")
    private long lockVersion;

}
