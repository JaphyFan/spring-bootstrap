package com.japhy.springbootjpa.infrastructure.jpa;

import java.util.Objects;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * @author Japhy
 * @since 2022/9/23 11:25
 */
@Converter(autoApply = true)
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        return Objects.isNull(attribute) || !attribute ? 0 : 1;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer dbData) {
        return Objects.equals(dbData, 1);
    }
}
