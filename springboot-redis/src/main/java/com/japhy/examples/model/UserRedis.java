package com.japhy.examples.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import java.io.Serializable;
import lombok.Builder;

/**
 * @author Japhy
 * @date 2020/2/6 10:19
 */
@Builder
public class UserRedis implements Serializable {

    private static final long serialVersionUID = -1541408164202572383L;
    private Long id;

    private String name;

    private Long age;

    public UserRedis() {
    }

    public UserRedis(Long id, String name, Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
