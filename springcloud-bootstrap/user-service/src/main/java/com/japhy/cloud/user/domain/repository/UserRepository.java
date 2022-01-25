package com.japhy.cloud.user.domain.repository;

import com.japhy.cloud.user.domain.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Japhy
 * @since 2022/1/18 10:41
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Transactional(readOnly = true)
    List<User> queryByNameLike(String name);

}
