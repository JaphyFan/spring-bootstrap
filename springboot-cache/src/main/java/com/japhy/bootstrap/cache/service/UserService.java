package com.japhy.bootstrap.cache.service;

import com.japhy.bootstrap.cache.entity.User;
import com.japhy.bootstrap.cache.repository.UserCrudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @date 2020/1/16 22:02
 */
@Service
public class UserService {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Cacheable(cacheNames = "user", key = "#name")
    public List<User> queryUsersByName(String name) {
        System.out.printf("the method is invoked");
        return userCrudRepository.queryUsersByNameContains(name);
    }
}
