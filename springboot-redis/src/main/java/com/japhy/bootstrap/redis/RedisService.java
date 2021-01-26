package com.japhy.bootstrap.redis;

import com.google.common.collect.Lists;
import com.japhy.bootstrap.redis.model.UserRedis;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate redisTemplate;


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

    @Cacheable(cacheNames = "question")
    public List<UserRedis> query(UserRedis userRedis) {
        log.info("in to servcie");
        UserRedis user1 =
            UserRedis.builder().address("huzhou").age(1L).gender(1).mobile(1232L).name("fanjh")
                .id(2L).build();
        UserRedis user2 =
            UserRedis.builder().address("jiaxing").age(1L).gender(2).mobile(124243L).name("grand")
                .id(3L).build();
        UserRedis user3 =
            UserRedis.builder().address("henan").age(1L).gender(3).mobile(126663L).name("albin")
                .id(4L).build();
        UserRedis user4 =
            UserRedis.builder().address("hangzhou").age(1L).gender(1).mobile(132623L).name("simon")
                .id(1L).build();
        ArrayList<UserRedis> userRedis1 = Lists.newArrayList(user1, user2);
        ArrayList<UserRedis> userRedis2 = Lists.newArrayList(user3, user4);
        if (userRedis.getId().equals(1L)) {
            return userRedis1;
        } else {
            return userRedis2;
        }
    }
}
