package com.yang.test.ymkfeignconsumer.feign;

import com.yang.test.api.TestService;
import com.yang.test.ymkfeignconsumer.config.FeignDisableHystrixConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "provider", configuration = FeignDisableHystrixConfiguration.class)
public interface TestFeignClient2 extends TestService {

}
