package com.japhy.bootstrap.cache.repository;

import com.japhy.bootstrap.cache.entity.User;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Japhy
 * @date 2020/1/16 22:08
 */
public interface UserCrudRepository extends CrudRepository<User, Long> {

    List<User> queryUsersByNameContains(String name);

    Stream<User> streamUserByNameContains(String name);

    User findByName(String name);

}
