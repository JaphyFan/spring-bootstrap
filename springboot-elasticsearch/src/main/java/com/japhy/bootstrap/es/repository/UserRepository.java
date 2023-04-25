package com.japhy.bootstrap.es.repository;

import com.japhy.bootstrap.es.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Japhy
 * @since 2023/4/20 20:33
 */
public interface UserRepository extends CrudRepository<User, Long> {



}
