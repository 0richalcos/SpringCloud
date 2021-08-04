package com.orichalcos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String demo() {
        LOGGER.info("order被调用，服务端口为：{}", port);
        return "order demo OK!!,服务端口为：" + port;
    }
}
