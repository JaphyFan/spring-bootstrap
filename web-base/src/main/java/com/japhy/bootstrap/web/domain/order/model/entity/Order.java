package com.japhy.bootstrap.web.domain.order.model.entity;

import com.japhy.bootstrap.web.domain.order.enums.OrderStatus;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Japhy
 * @since 2021/1/8 12:32
 */
@Entity
@Data
@Table(name = "web_order")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "order_no", unique = true, length = 20)
    private String orderNo;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")

    private Date updateTime;

    @Column(name = "operator_id")
    private Long operatorId;

    private Integer status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @PrePersist
    void createAt() {
        this.createTime = LocalDateTime.now();
        this.status = OrderStatus.CREATED.getStatus();
        // get current user
    }

    @PreUpdate
    void updateAt() {
        this.updateTime = new Date();
    }

}
