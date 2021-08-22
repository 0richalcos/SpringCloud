package com.orichalcos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Value("${server.port}")
    private String port;

    @GetMapping("/product")
    public String product() {
        LOGGER.info("进入商品服务.....");
        return "product ok，当前提供服务窗口：" + port;
    }
}
