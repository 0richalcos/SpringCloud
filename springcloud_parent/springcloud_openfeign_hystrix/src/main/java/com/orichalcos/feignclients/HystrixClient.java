package com.orichalcos.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hystrix", fallback = HystrixFallBack.class)
public interface HystrixClient {
    @GetMapping("/demo")
    String demo(@RequestParam("id") int id);
}
