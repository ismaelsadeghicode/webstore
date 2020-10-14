package com.mapsa.webstore.product.security;

import com.mapsa.webstore.product.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= userRepository.findByUsername(username);
       UserPrenciple userPrenciple=new UserPrenciple(user);
        return userPrenciple;
    }
    public UserDetails getCurrentUserDetails(){
        return (UserDetails) ((UserPrenciple)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }
    public User getCurrentUser(){
        return  ((UserPrenciple)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }
}
