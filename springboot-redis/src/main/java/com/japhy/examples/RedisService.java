package com.japhy.examples;

import com.japhy.examples.model.UserRedis;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Japhy
 * @since 1.0
 */
@Service
@Slf4j
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate) {
        Assert.notNull(redisTemplate, "redisTemplate is required");
        this.redisTemplate = redisTemplate;
    }

    @Cacheable(value = "user", key = "#userRedis.getId()")
    public UserRedis saveUser(UserRedis userRedis) {
        log.trace("user{} is saved", userRedis);
        return userRedis;
    }

    @Cacheable(value = "cacheList", key = "#name")
    public List<UserRedis> queryUserList(String name, List<UserRedis> userRedisList) {
        log.trace("users is listed");
        return userRedisList;
    }
}
