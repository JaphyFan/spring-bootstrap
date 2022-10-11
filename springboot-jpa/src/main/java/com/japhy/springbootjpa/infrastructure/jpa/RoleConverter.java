package com.japhy.springbootjpa.infrastructure.jpa;

import com.japhy.springbootjpa.infrastructure.enums.Role;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Japhy
 * @since 2022/9/23 13:11
 */
@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Role attribute) {
        return attribute.getId();
    }

    @Override
    public Role convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        return Arrays.stream(Role.values()).filter(role -> Objects.equals(role.getId(), dbData))
                .findAny().orElseThrow(() -> new IllegalArgumentException("未找到枚举值"));
    }
}
