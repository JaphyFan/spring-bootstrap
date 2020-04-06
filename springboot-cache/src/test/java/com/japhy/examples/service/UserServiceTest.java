package com.japhy.examples.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.japhy.examples.entity.User;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * @author Japhy
 * @date 2020/1/16 22:12
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    void queryUsersByName() {
        for (int i = 0; i < 3; i++) {
            List<User> fan = userService.queryUsersByName("BlKzq");
            System.out.println(fan);
        }
    }

    @Test
    void testContain() {
        List<User> fan = userService.queryUsersByName("BlKzq");
        assertThat(fan).hasSize(1);
        assertThat(fan.get(0).getId()).isEqualTo(30001);
    }

    @BeforeEach
    void setUp() {
        userService.queryUsersByName("BlKzq");
    }

    @Test
    void validateCache() {
        userService.queryUsersByName("BlKzq");
        Cache user = this.cacheManager.getCache("user");
        assertThat(user).isNotNull();
        user.clear();
        assertThat(user.get("BlKzq")).isNull();
    }
}