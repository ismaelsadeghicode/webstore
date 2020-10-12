package com.mapsa.webstore.product.controller;

import com.mapsa.webstore.product.domain.User;
import com.mapsa.webstore.product.security.AuthResponseDto;
import com.mapsa.webstore.product.security.LoginRequestDto;
import com.mapsa.webstore.product.security.RegisterRequestDto;
import com.mapsa.webstore.product.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("auth")
@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    /*@PostMapping("/register")
    public ResponseEntity<User> register(@ModelAttribute RegisterRequestDto requestDto){
      return ResponseEntity.ok(userService.save(requestDto));
       *//* System.out.println(requestDto.getPassword());
        return ResponseEntity.ok(new User());*//*
    }*/

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequestDto requestDto){
        //return ResponseEntity.ok(userService.save(requestDto));
       /* System.out.println(requestDto.getPassword());
        return ResponseEntity.ok(new User());*/
        userService.save(requestDto);
        System.out.println("*******************************************************************************controllerregister");
        return "succeas";

    }
    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequestDto loginRequestDto, Model model){
        model.addAttribute("authResponseDto",userService.login(loginRequestDto));
        return "products";

    }

}
