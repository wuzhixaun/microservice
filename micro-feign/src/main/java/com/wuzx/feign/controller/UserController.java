package com.wuzx.feign.controller;

import com.wuzx.common.model.user.UserInfo;
import com.wuzx.feign.client.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description 用户Controller
 * @createTime 2021年04月25日 14:44:00
 */
@RestController
@RequestMapping("/inner/user")
public class UserController {


    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/info/{id}")
    public UserInfo getUserInfoRpc(@PathVariable("id") Long id) {
        return userFeignClient.getUserInfoById(id);
    }
}
