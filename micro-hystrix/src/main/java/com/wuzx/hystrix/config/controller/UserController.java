package com.wuzx.hystrix.config.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wuzx.common.model.user.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName RPCController.java
 * @Description ribbon Rpc
 * @createTime 2021年04月25日 11:38:00
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserInfoFallBack")
    @GetMapping("/user/{id}")
    public UserInfo getUserInfo(@PathVariable Long id) {
        return restTemplate.getForObject("http://micro-user/user/{id}", UserInfo.class, id);
    }

    public UserInfo getUserInfoFallBack(Long id, Throwable throwable) {
        log.error("进入回退方法", throwable);
        return new UserInfo(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }

}
