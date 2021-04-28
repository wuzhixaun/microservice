package com.wuzx.user.service.impl;

import com.wuzx.user.dao.UserRepository;
import com.wuzx.user.entity.UserInfo;
import com.wuzx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2021年04月23日 14:57:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserInfo> findById(Long id) {
        return userRepository.findById(id);
    }

}
