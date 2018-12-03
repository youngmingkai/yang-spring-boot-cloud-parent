//package com.yang.test.ymkfeignconsumer.feign;
//
//import feign.hystrix.FallbackFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@FeignClient(name = "provider", fallbackFactory = FeignClientFallbackFactory.class)
//public interface TestFeignClientFallBack {
//     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    String hello(@PathVariable("id") String name);
//}
//
///**
// * UserFeignClient的fallbackFactory类，该类需实现FallbackFactory接口，并覆写create方法
// */
//@Component
//class FeignClientFallbackFactory implements FallbackFactory<TestFeignClientFallBack> {
//
//  @Override
//  public TestFeignClientFallBack create(Throwable cause) {
//    return new TestFeignClientFallBack() {
//      @Override
//      public String hello(String name) {
//        // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
//        // 否则在引用启动时，就会打印该日志。
//        System.out.println("fallback; reason was:"+ cause);
//        return name;
//      }
//    };
//  }
//}