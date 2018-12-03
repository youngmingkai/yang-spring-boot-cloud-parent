package com.yang.test.ymkfeignconsumer.config;

import feign.Feign;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author yangmingkai
 * @ClassName FeignDisableHystrixConfiguration
 * @Description TODO
 * @date 2018/10/31 4:16 PM
 **/
@Configuration
public class FeignDisableHystrixConfiguration {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuider() {

        return Feign.builder();
    }
}
