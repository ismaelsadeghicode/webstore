package com.mapsa.webstore.product.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class LoginRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
