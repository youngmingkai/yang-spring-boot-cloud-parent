package com.yang.test.ymkprovider.controller;

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
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        System.out.println("Hello " + name);
        return "Hello " + name;
    }
}
