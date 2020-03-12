package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * #映射说明如下
 * #/{application}/{profile}[/{label}]
 * #/{application}-{profile}.yml
 * #/{label}/{application}-{profile}.yml
 * #/{application}-{profile}.properties
 * #/{label}/{application}-{profile}.properties
 *  例如：  cus-pro.yml
 *  application 是 cus    profile 是 pro  label 是分支名
 *
 * 服务端引入jar
 <dependency>
 <groupId>org.springframework.cloud</groupId>
 <artifactId>spring-cloud-config-server</artifactId>
 </dependency>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
