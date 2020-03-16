package com.japhy.examples.api;

import com.japhy.examples.RedisService;
import com.japhy.examples.model.UserRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @date 2020/2/10 10:38
 */
@RestController
@RequestMapping("api/redis")
public class RedisApi {

    @Autowired
    private RedisService redisService;

    @GetMapping("/user")
    public UserRedis getUser() {
        UserRedis userRedis = UserRedis.builder().id(3L).name("japhy").age(10L).build();
        UserRedis user = redisService.saveUser(userRedis);
        return user;
    }
}
