package com.orichalcos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public String invokeDemo() {
        LOGGER.info("user demo...");

        //调用订单服务 服务地址： http://localhost:9999/order 必须GET方式 接收返回值 String 类型
        RestTemplate restTemplate = new RestTemplate();
        String orderResult = restTemplate.getForObject("http://localhost:9998/order", String.class);

        LOGGER.info("调用订单服务成功:{}", orderResult);
        return "调用订单服务成功,结果为:" + orderResult;
    }
}
