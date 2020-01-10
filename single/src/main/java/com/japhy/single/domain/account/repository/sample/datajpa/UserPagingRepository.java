package com.japhy.single.domain.account.repository.sample.datajpa;

import com.japhy.single.domain.account.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Japhy
 * @date 2019/12/30 23:12
 */
public interface UserPagingRepository extends PagingAndSortingRepository<User, Long> {

}
