package com.example.feign.fallback;

import com.example.feign.service.FeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 异常处理s
 */
@Component
public class FeignServiceFallbackFactory implements FallbackFactory<FeignService> {
    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService(){
            @Override
            public List getList() {
                return null;
            }
        };
    }
}
