package com.japhy.examples.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author Japhy
 * @date 2020/2/5 17:21 {@code @EnableRedisHttpSession} 配置 redis 分布式session,最大30天
 */
//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class SessionConfig {

}
