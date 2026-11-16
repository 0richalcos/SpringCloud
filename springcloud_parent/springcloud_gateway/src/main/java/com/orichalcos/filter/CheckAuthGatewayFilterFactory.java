package com.orichalcos.filter;


import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CheckAuthGatewayFilterFactory
        extends AbstractGatewayFilterFactory<CheckAuthGatewayFilterFactory.Config> {

    public CheckAuthGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // 获取请求头中的 Token
            String token = exchange.getRequest()
                    .getHeaders()
                    .getFirst("Authorization");

            // 校验 Token
            if (token == null || token.isEmpty()) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            // 校验通过，继续执行过滤器链
            return chain.filter(exchange);
        };
    }

    public static class Config {
        // 预留过滤器配置参数
    }


}
