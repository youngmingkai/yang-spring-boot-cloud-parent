package com.yang.test.ymkfeignconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yang.test.ymkfeignconsumer.feign.TestFeignClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "feign2")
public class HelloController2 {

    @Autowired
    TestFeignClient2 testFeignClient2;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/hello2")
    public String hello(@RequestParam String name) {
        String str = testFeignClient2.hello(name);
        return str;
    }

    @GetMapping("/log-user-instance2")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider");
        // 打印当前选择的是哪个节点
        System.out.println("{}:{}:{}," + serviceInstance.getServiceId() + "," + serviceInstance.getHost() + "," + serviceInstance.getPort());
    }

    @HystrixCommand(fallbackMethod = "helloFallBack3")
    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello2(@RequestParam String name) {
        String str = testFeignClient2.hello(name);
        return str;
    }

    //   回退方法有跟正常方法一样的参数
    public String helloFallBack3(String name, Throwable throwable) {
        System.out.println(throwable);
        return "helloFallBack3 " + name;
    }
}
