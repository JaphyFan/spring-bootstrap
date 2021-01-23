package com.japhy.bootstrap.web.application.event.subscriber;

import com.japhy.bootstrap.web.domain.order.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2021/1/23 18:08
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class OrderCreatedSubscriber {

    @EventListener
    public String subscribe(OrderCreatedEvent orderCreatedEvent) {
        log.info(orderCreatedEvent + " received ========");
        return orderCreatedEvent.getOrder().getOrderNo();
    }

}
