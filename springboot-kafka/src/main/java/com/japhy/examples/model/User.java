package com.japhy.examples.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Japhy
 * @date 2020/3/16 16:31
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    private String name;

    private Long age;

}
