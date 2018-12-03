package com.yang.test.ymkconfigclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class YmkConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmkConfigClientApplication.class, args);
    }
}
