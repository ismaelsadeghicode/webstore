package com.mapsa.webstore.product.security;

import com.mapsa.webstore.product.domain.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class RegisterRequestDto {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String role;

}
