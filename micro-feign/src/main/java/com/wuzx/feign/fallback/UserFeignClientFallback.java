package com.wuzx.feign.fallback;

import com.wuzx.common.model.user.UserInfo;
import com.wuzx.feign.client.UserFeignClient;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName UserFeignClientFallback.java
 * @Description UserFeign
 * @createTime 2021年04月26日 15:04:00
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public UserInfo getUserInfoById(Long id) {
        return new UserInfo(id, "默认用户", "默认用户", 0, new BigDecimal(111));
    }
}
