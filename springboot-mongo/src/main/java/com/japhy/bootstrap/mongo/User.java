package com.japhy.bootstrap.mongo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

/**
 * @author Japhy
 * @since 2023/3/27 15:05
 */
@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    private LocalDateTime dateTime;

    private LocalDate localDate;

    private long longDateTime;

    private Boolean aBoolean;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal bigDecimal;

}
