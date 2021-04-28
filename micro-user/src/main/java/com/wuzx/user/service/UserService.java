package com.wuzx.user.service;

import com.wuzx.user.entity.UserInfo;

import java.util.Optional;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description 用户接口
 * @createTime 2021年04月23日 14:56:00
 */
public interface UserService {
    /**
     * 根据id查询user信息
     *
     * @param id
     * @return
     */
    Optional<UserInfo> findById(Long id);
}
