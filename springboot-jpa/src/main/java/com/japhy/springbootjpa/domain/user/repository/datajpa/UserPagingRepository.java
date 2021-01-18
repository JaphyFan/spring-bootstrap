package com.japhy.springbootjpa.domain.user.repository.datajpa;

import com.japhy.springbootjpa.domain.user.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Japhy
 * @date 2019/12/30 23:12
 */
public interface UserPagingRepository extends PagingAndSortingRepository<User, Long> {

}
