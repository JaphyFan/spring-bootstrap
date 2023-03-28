package com.japhy.bootstrap.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Japhy
 * @since 2023/3/27 15:05
 */
@Data
@Document
public class User {

    @Id
    private String id;

}
