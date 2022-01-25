package com.japhy.cloud.user.application.mapper;

import com.japhy.cloud.user.application.dto.UserDto;
import com.japhy.cloud.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Japhy
 * @since 2022/1/21 15:35
 */
@Mapper
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    UserDto entityToDto(User user);
}
