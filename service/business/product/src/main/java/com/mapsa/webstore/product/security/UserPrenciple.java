package com.mapsa.webstore.product.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
@Getter
public class UserPrenciple extends User {
    com.mapsa.webstore.product.domain.User user;
    public UserPrenciple(com.mapsa.webstore.product.domain.User user) {
        super(user.getUsername(), user.getPassword(), user.getRoles());
        this.user=user;
    }


    /*
    public UserPrenciple(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }*/
}
