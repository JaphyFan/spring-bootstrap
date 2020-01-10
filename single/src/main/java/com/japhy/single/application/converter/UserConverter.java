package com.japhy.single.application.converter;

import com.japhy.single.domain.account.entity.User;
import com.japhy.single.infrastructure.helper.Converter;
import com.japhy.single.api.dto.UserDTO;
import java.util.function.Function;

/**
 * @author Japhy
 * @date 2020/1/2 02:17
 */
public class UserConverter extends Converter<UserDTO, User> {

    public UserConverter(
            Function<UserDTO, User> fromDto,
            Function<User, UserDTO> fromEntity) {
        super(fromDto, fromEntity);
    }
}
