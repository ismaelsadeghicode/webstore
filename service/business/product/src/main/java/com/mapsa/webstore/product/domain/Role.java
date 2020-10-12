package com.mapsa.webstore.product.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    customer, admin;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
