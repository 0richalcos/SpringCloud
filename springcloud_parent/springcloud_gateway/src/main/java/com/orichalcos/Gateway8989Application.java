package com.orichalcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Orichalcos
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Gateway8989Application {
    public static void main(String[] args) {
        SpringApplication.run(Gateway8989Application.class, args);
    }
}
