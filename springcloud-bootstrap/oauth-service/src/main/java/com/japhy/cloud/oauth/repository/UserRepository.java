package com.japhy.cloud.auth.repository;

import com.japhy.cloud.auth.entity.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    Long save(User user);

    Optional<User> findById(Long userId);

    User findUserByEmail(String email);
}
