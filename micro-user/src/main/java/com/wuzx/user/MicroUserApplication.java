package com.wuzx.user;

import com.wuzx.user.dao.UserRepository;
import com.wuzx.user.entity.UserInfo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;

@SpringBootApplication
public class MicroUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroUserApplication.class, args);
    }

    @Bean
    ApplicationRunner init(UserRepository repository) {
        return args -> {
            UserInfo user1 = new UserInfo(1L, "account1", "张三", 20, new BigDecimal(100.00));
            UserInfo user2 = new UserInfo(2L, "account2", "李四", 28, new BigDecimal(180.00));
            UserInfo user3 = new UserInfo(3L, "account3", "王五", 32, new BigDecimal(280.00));
            Stream.of(user1, user2, user3).forEach(repository::save);
        };
    }
}
