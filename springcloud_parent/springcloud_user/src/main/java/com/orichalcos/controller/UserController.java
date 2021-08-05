package com.orichalcos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping
    public String invokeDemo() {
        LOGGER.info("user demo...");

        //调用订单服务 服务地址： http://localhost:9999/order 必须GET方式 接收返回值 String 类型
        RestTemplate restTemplate = new RestTemplate();
        String orderResult = restTemplate.getForObject("http://localhost:9998/order", String.class);

        LOGGER.info("调用订单服务成功:{}", orderResult);
        return "调用订单服务成功,结果为:" + orderResult;
    }

    @GetMapping("/discoveryClient")
    public String discoveryClient() {
        //获取服务列表
        List<ServiceInstance> orders = discoveryClient.getInstances("order");
        orders.forEach(order -> {
            LOGGER.info("服务主机：【{}】", order.getHost());
            LOGGER.info("服务端口：【{}】", order.getPort());
            LOGGER.info("服务地址：【{}】", order.getUri());
        });
        //从服务列表中随机调取一个服务
        ServiceInstance order = orders.get(new Random().nextInt(orders.size()));
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(order.getUri() + "/order", String.class);
        return "User服务调用OK，" + result;
    }

    @GetMapping("/loadBalancerClient")
    public String loadBalancerClient() {
        //根据负载均衡策略选取某一个服务调用
        ServiceInstance order = loadBalancerClient.choose("order");
        LOGGER.info("服务主机：【{}】", order.getHost());
        LOGGER.info("服务端口：【{}】", order.getPort());
        LOGGER.info("服务地址：【{}】", order.getUri());
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(order.getUri() + "/order", String.class);
        return "User服务调用OK，" + result;
    }

    @GetMapping("/loadBalanced")
    public String loadBalanced() {
        String result = restTemplate.getForObject("http://order/order", String.class);
        return "User服务调用OK，" + result;
    }
}
