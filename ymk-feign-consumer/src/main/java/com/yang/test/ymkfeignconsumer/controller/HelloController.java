package com.yang.test.ymkfeignconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yang.test.ymkfeignconsumer.feign.TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "feign")
public class HelloController {

    @Autowired
    TestFeignClient testFeignClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        String str = testFeignClient.hello(name);
        return str;
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider");
        // 打印当前选择的是哪个节点
        System.out.println("{}:{}:{}," + serviceInstance.getServiceId() + "," + serviceInstance.getHost() + "," + serviceInstance.getPort());
    }

}
