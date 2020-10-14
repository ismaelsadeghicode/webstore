package com.mapsa.webstore.product.controller;

import com.mapsa.webstore.product.domain.OrderTbl;
import com.mapsa.webstore.product.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;
    @GetMapping
    public String orders(Model model){
        model.addAttribute("orders",orderService.findAll());
        return "orders";
    }
    @GetMapping("close")
    public String closeOrder(Model model){
        model.addAttribute("orders",orderService.closeOrder());
        return "orders";
    }
}
