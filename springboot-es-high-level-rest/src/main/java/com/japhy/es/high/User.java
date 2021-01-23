package com.japhy.es.high;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Japhy
 * @since 2021/1/19 11:01
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String name;

    private int age;

    private String gender;
}
