package com.japhy.bootstrap.web.infrastructure.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Japhy
 * @since 2021/1/12 09:49
 */
public class Converter<T, U> {

    private final Function<T, U> toDto;

    private final Function<U, T> toEntity;

    public Converter(Function<T, U> toDto, Function<U, T> toEntity) {
        this.toDto = toDto;
        this.toEntity = toEntity;
    }

    public static <T, U> Converter<T, U> of(Function<T, U> toDto,
        Function<U, T> toEntity) {
        return new Converter<>(toDto, toEntity);
    }

    public final U fromEntity(final T t) {
        return toDto.apply(t);
    }

    public final T fromDto(final U u) {
        return toEntity.apply(u);
    }

    public final List<U> fromEntities(final List<T> t) {
        return t.stream().map(this::fromEntity).collect(Collectors.toList());
    }

    public final List<T> fromDtos(final List<U> u) {
        return u.stream().map(this::fromDto).collect(Collectors.toList());
    }

}
