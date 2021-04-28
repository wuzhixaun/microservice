package com.wuzx.feign.client;

import com.wuzx.common.model.user.UserInfo;
import com.wuzx.feign.fallback.UserFeignClientFallback;
import com.wuzx.feign.fallback.UserFeignClientFallbackFactory;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName UserFeignClient.java
 * @Description 用户微服务
 * @createTime 2021年04月25日 14:38:00
 */

/**
 * 这是用来创建Ribbon Client的（Feign整合了Ribbon）。在本例中，由于使用了Eureka，
 * 所以Ribbon会把microservice-provider-user 解析成Eureka Server中的服务。
 */
@Component
@FeignClient(name = "micro-user", configuration = UserFeignConfig.class, fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    UserInfo getUserInfoById(@PathVariable("id") Long id);

}

/**
 * 该Feign Client的配置类，注意：
 *  * 1. 该类可以独立出去；
 *  * 2. 该类上也可添加@Configuration声明是一个配置类；
 *  * 配置类上也可添加@Configuration注解，声明这是一个配置类；
 *  * 但此时千万别将该放置在主应用程序上下文@ComponentScan所扫描的包中，
 *  * 否则，该配置将会被所有Feign Client共享，无法实现细粒度配置！
 *  * 个人建议：像我一样，不加@Configuration注解
 */
class UserFeignConfig {
    @Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }
}
