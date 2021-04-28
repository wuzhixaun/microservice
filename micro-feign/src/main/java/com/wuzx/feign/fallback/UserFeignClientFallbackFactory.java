package com.wuzx.feign.fallback;

import com.wuzx.common.model.user.UserInfo;
import com.wuzx.feign.client.UserFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName UserFeignClientFallbackFactory.java
 * @Description TODO
 * @createTime 2021年04月26日 15:10:00
 */
@Component
@Slf4j
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public UserInfo getUserInfoById(Long id) {
                log.error("进入回退逻辑", throwable);
                return new UserInfo(id, "默认用户", "默认用户", 0, new BigDecimal(1));
            }
        };
    }
}
