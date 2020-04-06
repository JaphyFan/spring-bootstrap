package com.japhy.examples.service;

import com.japhy.examples.entity.User;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

/**
 * @author Japhy
 * @date 2020/1/17 00:31
 */
@SpringBootTest
class UserCacheServiceTest {

    @Autowired
    private UserCacheService userCacheService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    void queryUserByName() {
        List<User> sMorT = userCacheService.queryUserByName("sMorT");
        Assertions.assertThat(sMorT).hasSize(2);
        List<User> s2 = userCacheService.queryUserByName("sMorT");

        List<User> s3 = userCacheService.queryUserByName("BlKzq");
        List<User> s4 = userCacheService.queryUserByName("BlKzq");
    }

    @Test
    void updateUser() {
        User sMorT = userCacheService.findUserByName("BlKzq");
        Cache user = cacheManager.getCache("user");
        Assertions.assertThat(user).isNotNull();
        User sMorT1 = (User) user.get("BlKzq").get();
        sMorT1.setName("fanjh");
        userCacheService.updateUser(sMorT1);
        Cache user2 = cacheManager.getCache("user");
        User fanjh = (User) user2.get("fanjh").get();
        Assertions.assertThat(sMorT1).isNotNull();
    }

    @Test
    void deleteCache() {
        User u1 = userCacheService.findUserByName("BlKzq");
        Cache user1 = cacheManager.getCache("user");
        Assertions.assertThat(user1.get("BlKzq")).isNotNull();
        userCacheService.deleteCache("BlKzq");
        Cache user = cacheManager.getCache("user");
        Assertions.assertThat(user.get("BlKzq")).isNull();
    }
}