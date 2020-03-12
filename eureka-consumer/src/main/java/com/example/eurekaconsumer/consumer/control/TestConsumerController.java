package com.example.eurekaconsumer.consumer.control;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestConsumerController {

    @Autowired
    RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://EUREKA-CLIENT/";

    /**
     * 此方法执行失败会调用fallbackMethod里面指定的方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "getDefaultList")
    @RequestMapping("/getList")
    public List getList(){
        List list = restTemplate.getForObject(REST_URL_PREFIX + "list", List.class);
        return list;
    }

    public List getDefaultList(){
        List list = new ArrayList();
        list.add(111);
        return list;
    }
}
