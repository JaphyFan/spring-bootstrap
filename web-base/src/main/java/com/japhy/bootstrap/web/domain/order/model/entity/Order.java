package com.japhy.bootstrap.web.domain.order.model.entity;

import com.japhy.bootstrap.web.domain.order.enums.OrderStatus;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
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
    private Long id;

    @Column(name = "order_no", unique = true, length = 20)
    private String orderNo;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "operator_id")
    private Long operatorId;

    private Integer status;

    @PrePersist
    void createAt() {
        this.createTime = new Date();
        this.status = OrderStatus.CREATED.getStatus();
        // get current user
    }

    @PreUpdate
    void updateAt() {
        this.updateTime = new Date();
    }

}
