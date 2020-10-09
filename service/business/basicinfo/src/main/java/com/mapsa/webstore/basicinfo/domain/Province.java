package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@SequenceGenerator(
        name = "province_seq",
        sequenceName = "PROVINCE_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class Province {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "province_seq")
    private long id;
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
    private Long lockVersion;
    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID", nullable = false)
    private Country countryByCountryId;

}
