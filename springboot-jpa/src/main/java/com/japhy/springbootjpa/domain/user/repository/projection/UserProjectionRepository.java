package com.japhy.springbootjpa.domain.user.repository.projection;

import com.japhy.springbootjpa.domain.user.entity.User;
import com.japhy.springbootjpa.domain.user.projection.UserClosedProjection;
import com.japhy.springbootjpa.domain.user.projection.UserDtoProjection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Japhy
 * @since 2021/4/12 10:49
 */
public interface UserProjectionRepository extends CrudRepository<User, Long> {

    List<UserClosedProjection> findByIdGreaterThan(Long id);

    List<UserDtoProjection> findByIdLessThan(Long id);

    @Query(value = "select name from user", nativeQuery = true)
    List<UserClosedProjection> queryNative();
}
