package com.japhy.bootstrap.cache.service;

import com.japhy.bootstrap.cache.entity.User;
import com.japhy.bootstrap.cache.repository.UserCrudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @date 2020/1/17 00:23
 */
@Component
public class UserCacheService {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Cacheable(value = "users", key = "#name", condition = "#name != null")
    public List<User> queryUserByName(String name) {
        System.out.println("the method is invoked");
        return userCrudRepository.queryUsersByNameContains(name);
    }

    @Cacheable(value = "user", key = "#name", condition = "#name != null")
    public User findUserByName(String name) {
        System.out.println("the method is invoked");
        return userCrudRepository.findByName(name);
    }

    @CachePut(value = "user", key = "#user.getName()")
    public User updateUser(User user) {
        return userCrudRepository.save(user);
    }

    @CacheEvict(value = "user")
    public void deleteCache(String name) {
//        userCrudRepository.deleteAll();
    }
}
