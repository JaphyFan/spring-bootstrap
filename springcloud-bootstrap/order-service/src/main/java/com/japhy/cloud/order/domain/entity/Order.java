package com.japhy.cloud.order.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Japhy
 * @since 2022/1/17 14:53
 */
@Document(collection = "order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private String id;

    @Version
    private int version;

    @Indexed(unique = true)
    private Integer orderId;

    private String orderName;

    private BigDecimal price;

    private LocalDateTime createTime;

    private Long customerId;

}
