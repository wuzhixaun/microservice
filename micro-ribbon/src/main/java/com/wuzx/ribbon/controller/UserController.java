package com.wuzx.ribbon.controller;

import com.wuzx.common.model.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName RPCController.java
 * @Description ribbon Rpc
 * @createTime 2021年04月25日 11:38:00
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public UserInfo getUserInfo(@PathVariable Integer id) {
        return restTemplate.getForObject("http://micro-user/user/{id}", UserInfo.class, id);
    }

}
