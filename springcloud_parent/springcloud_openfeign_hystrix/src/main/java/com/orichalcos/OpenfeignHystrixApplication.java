package com.orichalcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//开启OpenFeign调用
@EnableFeignClients
public class OpenfeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignHystrixApplication.class, args);
    }
}
