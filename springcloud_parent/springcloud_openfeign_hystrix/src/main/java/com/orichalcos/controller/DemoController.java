package com.orichalcos.controller;

import com.orichalcos.feignclients.HystrixClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private HystrixClient hystrixClient;

    @GetMapping("/test")
    public String test() {
        String result = hystrixClient.demo(-1);
        return "feignHystrix调用成功：" + result;
    }
}
