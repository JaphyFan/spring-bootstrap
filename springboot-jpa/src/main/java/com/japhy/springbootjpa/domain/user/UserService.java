package com.japhy.springbootjpa.domain.user;

import com.japhy.springbootjpa.domain.user.entity.Address;
import com.japhy.springbootjpa.domain.user.entity.User;
import com.japhy.springbootjpa.domain.user.repository.datajpa.AddressRepository;
import com.japhy.springbootjpa.domain.user.repository.datajpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Japhy
 * @since 2021/7/16 13:23
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserJpaRepository userJpaRepository;

    private final AddressRepository addressRepository;

    @Transactional
    public void saveUserAndAddress(int a, int b) {
        User japhy = User.builder().name("japhy").build();
        userJpaRepository.save(japhy);
        saveAddress(japhy);
        int i = a / b;
    }

    @Transactional
    public void saveAddress(User user) {
        Address build = Address.builder().userId(user.getId()).build();
        addressRepository.save(build);
    }

}
