package com.orichalcos.controller;

import com.orichalcos.feignclient.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
