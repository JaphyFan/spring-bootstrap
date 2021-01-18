package com.japhy.basic.lamda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Japhy
 * @since 2020/4/25 15:40
 */
@Data
@AllArgsConstructor
@Builder
public class Musician {

    private String name;

    private int age;

}
