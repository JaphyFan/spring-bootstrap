package com.japhy.cloud.user.application.service;

import com.japhy.cloud.user.application.dto.UserDto;

/**
 * @author Japhy
 * @since 2022/1/21 15:37
 */
public interface UserFacade {

    UserDto getUserById(Long userId);

}
