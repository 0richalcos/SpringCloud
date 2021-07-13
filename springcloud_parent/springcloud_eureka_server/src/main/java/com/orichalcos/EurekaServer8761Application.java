package com.orichalcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author oracleuser
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer8761Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer8761Application.class, args);
    }
}
