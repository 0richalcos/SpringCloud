package com.orichalcos.feignclients;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixFallBack implements HystrixClient {
    @Override
    public String demo(int id) {
        return "当前服务不可用,请稍后再试,id:" + id;
    }
}
