package com.mapsa.webstore.customer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class LegalCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    private String nameFa;
    private String nameEn;
    private Long economicCode;
    private String emailAddress;
    private String website;
    private String phoneNumber;
    private String status = "ACTIVE";
}
