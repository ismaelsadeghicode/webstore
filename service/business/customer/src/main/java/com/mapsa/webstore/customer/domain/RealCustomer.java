package com.mapsa.webstore.customer.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RealCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    // 0 for female   1 for male
    private Boolean gender;
    private String firstname;
    private String lastname;
    private Date birthDate;
    private String emailAddress;
    private String phoneNumber;
    private String status = "ACTIVE";
}
