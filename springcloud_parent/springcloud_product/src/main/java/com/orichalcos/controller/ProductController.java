package com.orichalcos.controller;

import com.orichalcos.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    //定义一个接收零散类型参数接口 queryString
    @GetMapping("/test1")
    public String test1(String name, Integer age) {
        LOGGER.info("name:{} age:{}", name, age);
        return "test1 ok，当前服务端口为：" + port;
    }

    //定义一个接收零散类型参数接口 路径传递参数
    @GetMapping("/test2/{id}/{name}")
    public String test2(@PathVariable("id") String id, @PathVariable("name") String name) {
        LOGGER.info("id:{} name{}", id, name);
        return "test2 ok，当前服务端口为：" + port;
    }

    //定义一个接收对象类型参数接口 application/json
    @PostMapping("/test3")
    public String test3(@RequestBody Product product) {
        LOGGER.info("product:{}", product);
        return "test3 ok，当前服务端口为：" + port;
    }
}
