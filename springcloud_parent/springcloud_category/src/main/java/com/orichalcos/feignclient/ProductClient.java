package com.orichalcos.feignclient;

import com.orichalcos.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//调用商品服务接口 value：用来书写被调用服务的服务Id
@FeignClient("product")
public interface ProductClient {

    //调用商品服务
    @GetMapping("/product")
    String product();

    @GetMapping("/test1")
    String test1(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @GetMapping("/test2/{id}/{name}")
    String test2(@PathVariable("id") String id, @PathVariable("name") String name);

    @PostMapping("/test3")
    String test3(@RequestBody Product product);
}
