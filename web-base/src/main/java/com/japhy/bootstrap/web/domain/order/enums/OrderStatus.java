package com.japhy.bootstrap.web.domain.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Japhy
 * @since 2021/1/10 12:22
 */
@ToString
@AllArgsConstructor
@Getter
public enum OrderStatus {

    /**
     * 订单已创建
     */
    CREATED(1),

    /**
     * 订单已支付
     */
    PAYED(10),

    /**
     * 订单已完成
     */
    FINISHED(100),

    ;

    private final int status;
}
