package com.example.eurekaconsumer;

import com.example.eurekaconsumer.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @EnableHystrix注解开启Hystrix的熔断器功能。
 * @RibbonClient开启负载均衡 name 服务名称  configuration 配置文件位置
 *
 */
@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@RibbonClient(name = "EUREKA-CLIENT", configuration = RibbonConfig.class)
public class EurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

}


