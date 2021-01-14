package com.japhy.examples;

import com.japhy.EmbeddedRedisConfig;
import com.japhy.examples.model.UserRedis;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author Japhy
 * @date 2020/2/6 13:24
 */
@SpringBootTest
@Import(EmbeddedRedisConfig.class)
class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void saveUser() {
        UserRedis japhy = UserRedis.builder().id(5L).name("japhy").age(10L).build();
        UserRedis userRedis = redisService.saveUser(japhy);
        Assertions.assertThat(userRedis).isNotNull();
        Assertions.assertThat(userRedis.getId()).isEqualTo(5L);
        Assertions.assertThat(userRedis.getName()).isEqualTo("japhy");
        Assertions.assertThat(userRedis.getAge()).isEqualTo(10L);
    }

    @Test
    void getUser() {

        stringRedisTemplate.opsForSet().add("user::6", "japhy6", "japhy7", "japhy8");
        String pop = stringRedisTemplate.opsForSet().pop("user::6");
        Assertions.assertThat(pop).isNotBlank();

        stringRedisTemplate.opsForValue().set("user::11", "japhy11");
        String user = stringRedisTemplate.opsForValue().get("user::11");
        Assertions.assertThat(user).isEqualTo("japhy11");

        UserRedis japhy4 = UserRedis.builder().id(4L).name("japhy").age(10L).build();
        ValueOperations<String, UserRedis> operations = redisTemplate.opsForValue();
        operations.set("user::4", japhy4);
        UserRedis userRedis = operations.get("user::4");
        Assertions.assertThat(userRedis).isNotNull();
        Assertions.assertThat(userRedis.getId()).isEqualTo(4L);

        UserRedis japhy15 = UserRedis.builder().id(15L).name("japhy").age(10L).build();
        UserRedis japhy16 = UserRedis.builder().id(16L).name("japhy").age(10L).build();
        ListOperations<String, UserRedis> listOperations = redisTemplate.opsForList();
        listOperations.leftPush("user::15", japhy15);
        listOperations.leftPush("user::15", japhy16);
        UserRedis userRedis1 = listOperations.leftPop("user::15");
        Assertions.assertThat(userRedis1).isNotNull();
        Assertions.assertThat(userRedis1.getId()).isEqualTo(16L);

        HashOperations<String, String, UserRedis> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("user::16", "16", japhy16);
        UserRedis userRedis2 = hashOperations.get("user::16", "16");
        Assertions.assertThat(userRedis2).isNotNull();
        Assertions.assertThat(userRedis2.getId()).isEqualTo(16L);
    }

    @Test
    void queryUserList() {
        UserRedis japhy1 = UserRedis.builder().id(1L).name("japhy").age(10L).build();
        UserRedis japhy2 = UserRedis.builder().id(2L).name("japhy").age(10L).build();
        UserRedis japhy3 = UserRedis.builder().id(3L).name("japhy").age(10L).build();
        UserRedis japhy4 = UserRedis.builder().id(4L).name("japhy").age(10L).build();
        UserRedis japhy5 = UserRedis.builder().id(5L).name("japhy").age(10L).build();
        List<UserRedis> userlist = redisService
                .queryUserList("userlist", Arrays.asList(japhy1, japhy2, japhy3, japhy4, japhy5));
    }
}