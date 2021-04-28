package com.wuzx.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class MicroZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroZuulApplication.class, args);
    }

}
