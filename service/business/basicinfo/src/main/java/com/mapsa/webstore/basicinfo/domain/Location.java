package com.mapsa.webstore.basicinfo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@SequenceGenerator(
        name = "location_seq",
        sequenceName = "LOCATION_SEQ",
        allocationSize = 1000,initialValue = 10000
)
public class Location {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "location_seq")
    private long id;
    @Basic
    @Column(name = "TITLE")
    private String title;
    @Basic
    @Column(name = "ADDRESS")
    private String address;
    @Basic
    @Column(name = "LATITUDE")
    private String latitude;
    @Basic
    @Column(name = "LONGITUDE")
    private String longitude;
    @Basic
    @Column(name = "REMARKS")
    private String remarks;
    @Basic
    @Column(name = "LOCK_VERSION")
    private Long lockVersion;
    @ManyToOne
    @JoinColumn(name = "CITY_ID", referencedColumnName = "ID", nullable = false)
    private City cityByCityId;

}
