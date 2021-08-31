package com.orichalcos.controller;

import com.orichalcos.entity.Product;
import com.orichalcos.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private ProductClient productClient;

    @GetMapping("/category")
    public String category() {
        String result = productClient.product();
        LOGGER.info("category service....." + result);
        return "category ok...." + result;
    }

    @GetMapping("/test1")
    public String test1(String name, Integer age) {
        String result = productClient.test1(name, age);
        return "category ok....." + result;
    }

    @GetMapping("/test2/{id}/{name}")
    public String test2(@PathVariable("id") String id, @PathVariable("name") String name) {
        String result = productClient.test2(id, name);
        return "category ok....." + result;
    }

    @GetMapping("/test3")
    public String test3() {
        String result = productClient.test3(new Product(1, "Orichalcos", 19.9, new Date()));
        return "category ok....." + result;
    }
}
