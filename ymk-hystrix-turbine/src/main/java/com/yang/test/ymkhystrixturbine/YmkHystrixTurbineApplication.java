package com.yang.test.ymkhystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine //表示开启Turbine
public class YmkHystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmkHystrixTurbineApplication.class, args);
    }
}
