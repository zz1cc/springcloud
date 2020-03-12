package com.example.feign.service;
import com.example.feign.fallback.FeignServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

// value eureka可以调用的服务名称   fallbackFactory 调用服务异常会进入此类处理
@FeignClient( value = "eureka-client", fallbackFactory = FeignServiceFallbackFactory.class)
public interface FeignService {

    @RequestMapping("/list")
    List getList();
}
