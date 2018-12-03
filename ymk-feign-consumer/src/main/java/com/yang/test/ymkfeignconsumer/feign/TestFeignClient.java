package com.yang.test.ymkfeignconsumer.feign;

import com.yang.test.ymkfeignconsumer.config.FeignLogConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangmingkai
 * @ClassName TestFeignClient
 * @Description TODO
 * @date 2018/10/29 3:21 PM
 **/
@FeignClient(name = "provider", configuration = FeignLogConfiguration.class, fallback = FeignClientFallback.class)
public interface TestFeignClient {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);
}

@Component
class FeignClientFallback implements TestFeignClient {
    @Override
    public String hello(String name) {
        return "FeignhelloFallBack " + name;
    }
}