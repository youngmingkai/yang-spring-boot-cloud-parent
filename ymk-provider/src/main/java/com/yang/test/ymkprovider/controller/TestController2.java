package com.yang.test.ymkprovider.controller;

import com.yang.test.api.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangmingkai
 * @ClassName TestController
 * @Description TODO
 * @date 2018/10/27 2:46 PM
 **/

@RestController
public class TestController2 implements TestService {

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello(String name) {
        System.out.println("Hello2 " + name);
        return "Hello2 " + name;
    }
}
