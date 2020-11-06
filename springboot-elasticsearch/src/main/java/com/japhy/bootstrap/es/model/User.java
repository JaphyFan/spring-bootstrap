package com.japhy.bootstrap.es.model;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Japhy
 * @since 2020/7/16 14:54
 */
@Document(indexName = "user2", shards = 2, replicas = 1)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @Id
    private String id;

    @Field(name = "time", type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    @CreatedDate
    private LocalDateTime time;

    @Field(name = "test5")
    private LocalDateTime test1;

    @Field(name = "test3", type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    private LocalDateTime test3;

    @Field(name = "test4", type = FieldType.Date_Nanos, format = DateFormat.date_optional_time)
    private ZonedDateTime test4;

    private String name;

    @LastModifiedDate
    @Field(name = "update_time", type = FieldType.Date, format = DateFormat.date_hour_minute_second)
    private LocalDateTime updateTime;

    @Field(name = "formatted_time", type = FieldType.Date, format = DateFormat.basic_date)
    private Date formattedTime;

    @Field(type = FieldType.Object)
    private Bank bank;

    @Field(name = "flattened_bank", type = FieldType.Flattened)
    private Bank flattenedBank;

}
