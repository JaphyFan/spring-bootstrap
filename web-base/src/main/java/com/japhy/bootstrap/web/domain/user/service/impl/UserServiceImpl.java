package com.japhy.bootstrap.web.domain.user.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.japhy.bootstrap.web.domain.user.entity.User;
import com.japhy.bootstrap.web.domain.user.repository.UserRepository;
import com.japhy.bootstrap.web.domain.user.service.UserService;
import com.japhy.bootstrap.web.interfaces.dto.CreateUserRequest;
import java.util.Optional;
import javax.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2021/1/8 17:33
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(CreateUserRequest userRequest) {
        Optional<User> byUserName = userRepository.findByUserName(userRequest.getUserName());
        if (byUserName.isPresent()) {
            throw new ValidationException("username already exists");
        }

        if (!userRequest.getPassword().equals(userRequest.getRePassword())) {
            throw new ValidationException("passwords dont match!");
        }

        if (userRequest.getAuthorities() == null) {
            userRequest.setAuthorities(Sets.newHashSet());
        }
        User user =
            User.builder().userName(userRequest.getUserName()).fullName(userRequest.getFullName())
                .password(passwordEncoder.encode(userRequest.getPassword())).grantedAuthorityList(Lists.newArrayList())
                .enabled(true)
                .build();

        User save = userRepository.save(user);
        return save;
    }
}
