package com.japhy.examples.config;

import java.util.Collection;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @date 2020/1/16 22:35
 */
@Configuration
@EnableCaching
public class BasicCacheConfig extends CachingConfigurerSupport {

//    @Bean
    public KeyGenerator myKeyGenerator() {
        return (target, method, params) -> {
            return null;
        };
    }

//    @Bean
    public CacheResolver myCacheResolver() {
        return context -> {
            return null;
        };
    }

//    @Bean
    public CacheManager myCacheManager() {
        return new CacheManager() {
            @Override
            public Cache getCache(String name) {
                return null;
            }

            @Override
            public Collection<String> getCacheNames() {
                return null;
            }
        };
    }
}
