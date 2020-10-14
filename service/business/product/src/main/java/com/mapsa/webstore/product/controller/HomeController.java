package com.mapsa.webstore.product.controller;

import com.mapsa.webstore.product.security.LoginRequestDto;
import com.mapsa.webstore.product.security.RegisterRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String homePage(Model model){
        /*LoginRequestDto loginRequestDto=new LoginRequestDto();
        model.addAttribute("loginRequestDto",loginRequestDto);*/
        RegisterRequestDto registerRequestDto=new RegisterRequestDto();
        model.addAttribute("registerRequestDto",registerRequestDto);
        return "register";
    }
}
