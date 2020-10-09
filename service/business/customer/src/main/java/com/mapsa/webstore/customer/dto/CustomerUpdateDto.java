package com.mapsa.webstore.customer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class CustomerUpdateDto {
    @NotBlank(message = "code is needed")
    private Long code;
    //private Location locationId;
    private String type;
    @NotBlank(message = "national code is needed")
    private Long nationalCode;
    private ZonedDateTime insertLocalTime;
}
