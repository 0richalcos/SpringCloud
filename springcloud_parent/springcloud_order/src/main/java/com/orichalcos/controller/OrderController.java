package com.orichalcos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping
    public String demo(){
        System.out.println("order demo start...");
        return "order demo OK!!";
    }
}
