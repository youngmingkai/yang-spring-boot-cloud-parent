package com.yang.test.ymkfeignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients("com.yang.test.ymkfeignconsumer.feign") //注解表示开启Spring Cloud Feign的支持功能，指定接口路径，防止出现无法注入的问题
public class YmkFeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmkFeignConsumerApplication.class, args);
    }
}
