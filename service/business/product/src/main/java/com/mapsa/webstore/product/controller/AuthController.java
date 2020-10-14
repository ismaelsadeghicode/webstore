package com.mapsa.webstore.product.controller;

import com.mapsa.webstore.product.security.RegisterRequestDto;
import com.mapsa.webstore.product.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping
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

        return "success";

    }
    @GetMapping("/login")
    public String login(){
        //model.addAttribute("authResponseDto",userService.login(loginRequestDto));
        return "login-register";
    }

}
