package com.japhy.bootstrap.web.domain.order.event;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Japhy
 * @since 2021/1/23 17:58
 */
@Getter
@ToString
public class OrderCreatedEvent {

    private Order order;

    public OrderCreatedEvent(Order order) {
        this.order = order;
    }
}
