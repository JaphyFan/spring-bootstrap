package com.japhy.bootstrap.redis.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Japhy
 * @since 1.0
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRedis implements Serializable {

    private static final long serialVersionUID = -1541408164202572383L;
    private Long id;

    private String name;

    private Long age;

    private String address;

    private Long mobile;

    private Integer gender;

}
