package com.wuzx.user.controller;

import com.wuzx.user.entity.UserInfo;
import com.wuzx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description 用户
 * @createTime 2021年04月23日 14:54:00
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/{id}")
    public Optional<UserInfo> findById(@PathVariable Long id) {
        return this.userService.findById(id);
    }
}
