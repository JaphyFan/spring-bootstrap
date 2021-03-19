package com.japhy.springbootjpa.domain.user.repository.datajpa;

import com.japhy.springbootjpa.domain.user.entity.User;
import com.japhy.springbootjpa.domain.user.projections.OpenProjection;
import com.japhy.springbootjpa.interfaces.dto.UserDto;
import com.japhy.springbootjpa.interfaces.dto.UserVo;
import java.util.List;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Japhy
 * @date 2019/12/30 23:10
 */
public interface UserCrudRepository extends CrudRepository<User, Long> {

    @Query(value = "select NEW com.japhy.springbootjpa.interfaces.dto.UserDto(id, name) from User ")
    List<UserDto> query4Dto();

    @Query(value = "select id, name from user ", nativeQuery = true)
    List<UserVo> query4VoNative();

    @Query(value = "select id, name from user ", nativeQuery = true)
    List<OpenProjection> query4InterfaceNative();

}
