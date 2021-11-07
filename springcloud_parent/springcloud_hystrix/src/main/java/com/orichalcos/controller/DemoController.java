package com.orichalcos.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/demo")
    //指定熔断时快速返回方法
    @HystrixCommand(fallbackMethod = "testBreakFall")
    public String testBreak(int id) {
        LOGGER.info("接收的Id为：{}", id);
        if (id < 0) {
            throw new RuntimeException("数据不合法");
        }
        return "接收的Id为：" + id;
    }

    public String testBreakFall(int id) {
        return "当前数据不合法：" + id;
    }

    @GetMapping("/default")
    @HystrixCommand(defaultFallback = "defaultFallback")
    public String defaultTest() {
        throw new RuntimeException("异常啦！");
    }

    public String defaultFallback() {
        return "此为默认响应";
    }
}
