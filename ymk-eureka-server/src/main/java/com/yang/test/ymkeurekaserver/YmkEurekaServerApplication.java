package com.yang.test.ymkeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //声明这是一个Eureka Server服务
public class YmkEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmkEurekaServerApplication.class, args);
    }
}
