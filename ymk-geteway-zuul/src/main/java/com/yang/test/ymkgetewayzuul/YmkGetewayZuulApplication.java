package com.yang.test.ymkgetewayzuul;

import com.yang.test.ymkgetewayzuul.filter.PermisFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy //声明一个Zuul代理
public class YmkGetewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmkGetewayZuulApplication.class, args);
    }

    //配置过滤器Bean
    @Bean
    PermisFilter permisFilter() {
        return new PermisFilter();
    }
}
