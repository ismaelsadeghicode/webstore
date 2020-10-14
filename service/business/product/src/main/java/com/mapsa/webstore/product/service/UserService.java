package com.mapsa.webstore.product.service;

import com.mapsa.webstore.product.converter.UserMapper;
import com.mapsa.webstore.product.domain.Role;
import com.mapsa.webstore.product.domain.User;
import com.mapsa.webstore.product.security.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserMapper{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
   // private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    //private final UserMapper userMapper;
    public User save(@Valid RegisterRequestDto user)  {

        User user1=new User();
        user1=registerDtoToUser(user);
        user1.setPassword(passwordEncoder.encode(user1.getPassword()));
       return userRepository.save(user1);
    }
   /* public AuthResponseDto login(LoginRequestDto loginRequestDto){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getUsername(),loginRequestDto.getPassword()));
        UserDetails userDetails=userDetailsService.loadUserByUsername(loginRequestDto.getUsername());

        return new AuthResponseDto().setToken(token).setUserName(userDetails.getUsername());

    }*/
  public  User getCurrentUser(){
      return userDetailsService.getCurrentUser();
  }
    @Override
    public User registerDtoToUser(RegisterRequestDto requestDto) {
        List<Role> roles=new ArrayList<>();
        User tempUser=new User();
        if (requestDto.getRole().equals(Role.customer)) {
            roles.add(Role.customer);
             tempUser = new User().setPassword(requestDto.getPassword())
                    .setUsername(requestDto.getUsername());;
            tempUser.setRoles(roles);
        }else{
            roles.add(Role.admin);
            tempUser = new User().setPassword(requestDto.getPassword())
                    .setUsername(requestDto.getUsername());;
            tempUser.setRoles(roles);
        }
      return tempUser;
    }
}
