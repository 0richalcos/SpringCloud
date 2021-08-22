package com.orichalcos.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//调用商品服务接口 value：用来书写被调用服务的服务Id
@FeignClient("product")
public interface ProductClient {

    //调用商品服务
    @GetMapping("/product")
    String product();
}
