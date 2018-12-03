package com.yang.test.ymkconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer //声明是一个Config Server
@EnableEurekaClient
public class YmkConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmkConfigServerApplication.class, args);
    }
}
