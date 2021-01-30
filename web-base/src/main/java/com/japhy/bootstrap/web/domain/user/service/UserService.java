package com.japhy.bootstrap.web.domain.user.service;

import com.japhy.bootstrap.web.domain.user.entity.User;
import com.japhy.bootstrap.web.interfaces.dto.CreateUserRequest;

/**
 * @author Japhy
 * @since 2021/1/8 17:33
 */
public interface UserService {

    User createUser(CreateUserRequest user);
}
