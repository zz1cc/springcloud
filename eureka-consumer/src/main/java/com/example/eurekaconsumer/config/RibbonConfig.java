package com.example.eurekaconsumer.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

    /**
     * @LoadBalanced：RestTemplate开启负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 负载均衡策略
     * @return
     * return new RandomRule() //分配策略：随机选择一个server
     * return new BestAvailableRule(); //分配策略：选择一个最小的并发请求的server，逐个考察Server，如果Server被tripped了，则忽略
     * return new RoundRobinRule(); //分配策略：轮询选择，轮询index，选择index对应位置的server
     * return new WeightedResponseTimeRule(); //分配策略：响应时间越长，weight越小，被选中的可能性越低
     * return new ZoneAvoidanceRule(); //分配策略：复合判断server所在区域的性能和server的可用性选择server
     * return new RetryRule(); //分配策略：对选定的负载均衡策略机上重试机制，在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server
    */
    @Bean
    public IRule myRule () {
        return new RandomRule(); //分配策略：随机选择一个server
    }

}
