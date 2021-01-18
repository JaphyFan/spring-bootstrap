package com.japhy.springbootjpa.domain.user.repository.datajpa;

import com.japhy.springbootjpa.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Japhy
 * @date 2019/12/30 23:10
 */
public interface UserCrudRepository extends CrudRepository<User, Long> {

}
