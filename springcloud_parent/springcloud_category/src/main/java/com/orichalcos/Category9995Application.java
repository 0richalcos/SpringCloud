package com.orichalcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//开启OpenFeign客户端调用
@EnableFeignClients
public class Category9995Application {
    public static void main(String[] args) {
        SpringApplication.run(Category9995Application.class, args);
    }
}
