package com.japhy.action.domain.taco.model.entity;

import com.japhy.action.domain.taco.enums.Type;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Japhy
 * @since 2020/7/6 14:50
 */
@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;

    private final String name;

    private final Type type;

}
