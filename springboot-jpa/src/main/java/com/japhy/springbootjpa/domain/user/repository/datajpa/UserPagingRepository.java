package com.japhy.springbootjpa.domain.user.repository.datajpa;

import com.japhy.springbootjpa.domain.user.entity.User;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author Japhy
 * @date 2019/12/30 23:12
 */
public interface UserPagingRepository extends PagingAndSortingRepository<User, Long> {

    @Query(value = "select * from user where name = :name",
            countQuery = "select count(*) from use where name = :name",
            nativeQuery = true)
    List<User> pageQuery(@Param("name") String name, Pageable pageable);
}
