package com.yang.test.ymkhystrixstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启仪表盘功能
public class YmkHystrixStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmkHystrixStreamApplication.class, args);
    }
}
