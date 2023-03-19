package com.japhy.cloud.user.application.service.impl;

import com.japhy.cloud.user.application.dto.UserDto;
import com.japhy.cloud.user.application.mapper.UserDtoMapper;
import com.japhy.cloud.user.application.service.UserFacade;
import com.japhy.cloud.user.domain.entity.User;
import com.japhy.cloud.user.domain.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2022/1/21 15:38
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserRepository userRepository;

    @Override
    public UserDto getUserById(Long userId) {
        UserDtoMapper userDtoMapper = UserDtoMapper.INSTANCE;

        Optional<User> byId = userRepository.findById(userId);

        return byId.map(userDtoMapper::entityToDto)
                .orElseThrow(() -> new IllegalArgumentException("No found user. user id is " + userId));
    }

}
