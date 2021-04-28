package com.wuzx.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName RestConfiguration.java
 * @Description TODO
 * @createTime 2021年04月25日 11:29:00
 */
@Configuration
public class RestConfiguration {


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
