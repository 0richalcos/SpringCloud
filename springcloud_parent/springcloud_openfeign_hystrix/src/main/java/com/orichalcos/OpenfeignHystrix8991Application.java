package com.orichalcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//开启OpenFeign调用
@EnableFeignClients
public class OpenfeignHystrix8991Application {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignHystrix8991Application.class, args);
    }
}
