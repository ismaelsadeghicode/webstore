package com.mapsa.webstore.customer.dto;

import com.mapsa.webstore.customer.domain.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class RealCustomerCreationDto {
    @NotBlank(message = "code is needed")
    private Long code;
    //private Location locationId;
    private String type;
    @NotBlank(message = "national code is needed")
    private Long nationalCode;
    @NotBlank(message = "make it clear that which customer this one is!")
    private Customer customer;
    // 0 for female   1 for male
    private Boolean gender;
    @NotBlank(message = "firstname required here")
    private String firstname;
    @NotBlank(message = "lastname required here")
    private String lastname;
    @Past
    private Date birthDate;
    @Email
    @NotBlank(message = "email needed!")
    private String emailAddress;
    @NotBlank(message = "phone number is needed")
    private String phoneNumber;
}
