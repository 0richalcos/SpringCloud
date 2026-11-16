package com.orichalcos.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// 实现一个简单的全局 Token 校验过滤器。
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {

        // 获取请求头中的 Token
        String token = exchange.getRequest()
                .getHeaders()
                .getFirst("Authorization");

        // 校验 Token
        if (token == null || token.isEmpty()) {
            exchange.getResponse()
                    .setStatusCode(HttpStatus.UNAUTHORIZED);

            return exchange.getResponse().setComplete();
        }

        // 校验通过，继续执行过滤器链
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // 数值越小，优先级越高
        return -1;
    }
}