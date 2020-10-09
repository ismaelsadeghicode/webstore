package com.mapsa.webstore.customer.dto;

import com.mapsa.webstore.customer.domain.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class LegalCustomerDto {
    @NotBlank(message = "make it clear that which customer this one is!")
    private Customer customer;
    @NotBlank(message = "name required here")
    private String nameFa;
    @NotBlank(message = "English name should be inserted")
    private String nameEn;
    @NotBlank(message = "economic code is needed")
    private Long economicCode;
    @Email
    @NotBlank(message = "email needed!")
    private String emailAddress;
    private String website;
    @NotBlank(message = "phone number is needed")
    private String phoneNumber;
}
