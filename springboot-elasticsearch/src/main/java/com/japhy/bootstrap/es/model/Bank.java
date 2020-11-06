package com.japhy.bootstrap.es.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Japhy
 * @since 2020/7/16 13:34
 */
@Document(indexName = "bank", shards = 1, replicas = 1)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Bank {

    @Id
    private Long id;

    @Field(name = "account_number", type = FieldType.Long)
    private long accountNumber;

    @Field
    private String address;

}
