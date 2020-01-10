package com.japhy.single.domain.account.repository.sample.datajpa;

import com.japhy.single.domain.account.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Japhy
 * @date 2019/12/30 23:10
 */
public interface UserCrudRepository extends CrudRepository<User, Long> {

}
