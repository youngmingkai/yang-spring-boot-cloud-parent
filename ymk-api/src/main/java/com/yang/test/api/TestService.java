package com.yang.test.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangmingkai
 * @ClassName TestFeignClient
 * @Description TODO
 * @date 2018/10/29 3:21 PM
 **/
public interface TestService {

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}
