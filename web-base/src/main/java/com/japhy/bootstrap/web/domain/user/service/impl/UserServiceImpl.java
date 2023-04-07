package com.japhy.bootstrap.web.domain.user.service.impl;

import com.google.common.collect.Sets;
import com.japhy.bootstrap.web.domain.user.entity.User;
import com.japhy.bootstrap.web.domain.user.enums.Role;
import com.japhy.bootstrap.web.domain.user.repository.UserRepository;
import com.japhy.bootstrap.web.domain.user.service.UserService;
import com.japhy.bootstrap.web.infrastructure.config.WebSecureConfig;
import com.japhy.bootstrap.web.interfaces.dto.CreateUserRequest;
import java.util.Objects;
import java.util.Optional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2021/1/8 17:33
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl {

}
