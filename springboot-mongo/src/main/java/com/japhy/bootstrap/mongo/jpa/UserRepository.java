package com.japhy.bootstrap.mongo.jpa;

import com.japhy.bootstrap.mongo.User;
import com.japhy.bootstrap.mongo.UserProjection;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Japhy
 * @since 2023/4/12 17:46
 */
public interface UserRepository extends MongoRepository<User, String> {


    Optional<UserProjection> findByName(String name);

    Optional<User> findByNameEquals(String name);
}
