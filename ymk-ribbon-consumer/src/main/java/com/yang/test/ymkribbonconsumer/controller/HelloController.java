package com.yang.test.ymkribbonconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //  HystrixCommand具有容错能力  fallbackMethod属性指定回退方法
    @HystrixCommand(fallbackMethod = "helloFallBack")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://provider/hello?name={1}", String.class, name);
        return responseEntity.getBody();
    }

    //   回退方法有跟正常方法一样的参数
    public String helloFallBack(String name, Throwable throwable) {
        System.out.println(throwable);
        return "helloFallBack " + name;
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider");
        // 打印当前选择的是哪个节点
        System.out.println("{}:{}:{}," + serviceInstance.getServiceId() + "," + serviceInstance.getHost() + "," + serviceInstance.getPort());
    }
}
