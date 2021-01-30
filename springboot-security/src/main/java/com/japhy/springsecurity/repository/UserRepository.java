package com.japhy.springsecurity.repository;

import com.japhy.springsecurity.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Japhy
 * @since 2021/1/27 15:26
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

}
