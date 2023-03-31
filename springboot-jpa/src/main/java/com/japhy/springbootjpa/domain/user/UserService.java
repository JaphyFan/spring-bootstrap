package com.japhy.springbootjpa.domain.user;

import com.japhy.springbootjpa.domain.user.entity.Address;
import com.japhy.springbootjpa.domain.user.entity.User;
import com.japhy.springbootjpa.domain.user.event.UserCreatedEvent;
import com.japhy.springbootjpa.domain.user.repository.datajpa.AddressRepository;
import com.japhy.springbootjpa.domain.user.repository.datajpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

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

    public void saveUserAndAddress() {
        User japhy = User.builder().name("testSave").build();
        userJpaRepository.save(japhy);
        saveAddress(japhy);
    }

    @Transactional
    public void saveAddress(User user) {
        Address build = Address.builder().user(user).build();
        addressRepository.save(build);
    }

    @TransactionalEventListener
    public void handleUserCreatedEvent(UserCreatedEvent userCreatedEvent) {

        log.info(userCreatedEvent.getUser().getName());

    }

}
