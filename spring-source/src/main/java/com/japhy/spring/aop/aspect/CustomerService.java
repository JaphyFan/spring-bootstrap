package com.japhy.spring.aop.aspect;

import lombok.NoArgsConstructor;

/**
 * @author Japhy
 * @since 2021/1/25 21:10
 */
public class CustomerService {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void throwException() {
        throw new IllegalStateException();
    }
}
