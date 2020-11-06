package com.japhy.bootstrap.es.service;

import com.japhy.bootstrap.es.model.User;
import java.util.Optional;
import org.springframework.data.elasticsearch.core.SearchHits;

/**
 * @author Japhy
 * @since 2020/7/16 15:33
 */
public interface UserService {

    User saveUser(User user);

    Optional<User> findByUser(String name);

    SearchHits<User> queryAllUsers();

}
