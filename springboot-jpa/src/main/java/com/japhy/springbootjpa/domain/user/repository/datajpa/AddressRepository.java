package com.japhy.springbootjpa.domain.user.repository.datajpa;

import com.japhy.springbootjpa.domain.user.entity.Address;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Japhy
 * @since 2021/7/16 13:11
 */
public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByUserId(Long userId);
}
