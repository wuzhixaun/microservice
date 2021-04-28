package com.wuzx.user.dao;

import com.wuzx.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName UserRepository.java
 * @Description
 * @createTime 2021年04月23日 14:51:00
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
