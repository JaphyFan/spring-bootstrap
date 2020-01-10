package com.japhy.single.infrastructure.helper;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @param <T> Dto type
 * @param <U> domain type
 * @author Japhy
 * @date 2020/1/2 01:29
 */
public class Converter<T, U> {

    private final Function<T, U> fromDto;

    private final Function<U, T> fromEntity;

    public Converter(final Function<T, U> fromDto, final Function<U, T> fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public static <T, U> Converter<T, U> of(Function<T, U> fromDto, Function<U, T> fromEntity) {
        return new Converter<>(fromDto, fromEntity);
    }

    public final T convertFromEntity(final U entity) {
        return fromEntity.apply(entity);
    }

    public final U convertFromDto(final T dto) {
        return fromDto.apply(dto);
    }

    public final List<T> convertFromEntities(final Collection<U> entities) {
        return entities.stream().map(fromEntity).collect(Collectors.toList());
    }

    public final List<U> converFromDtos(final Collection<T> dtos) {
        return dtos.stream().map(fromDto).collect(Collectors.toList());
    }

}
