package com.orichalcos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Value("${name}")
    private String name;

    @GetMapping("/test")
    public String test() {
        LOGGER.info("当前加载的配置为：[{}]", name);
        return name;
    }
}