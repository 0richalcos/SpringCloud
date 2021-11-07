package com.orichalcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
//开启Hystrix服务熔断
@EnableHystrix
public class Hystrix8990Application {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix8990Application.class, args);
    }
}
