package com.japhy.bootstrap.web.application.event.publisher;

import com.japhy.bootstrap.web.domain.order.event.OrderCreatedEvent;
import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2021/1/23 18:05
 */
@Component
@RequiredArgsConstructor
public class OrderCreatedEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(Order order) {
        applicationEventPublisher.publishEvent(new OrderCreatedEvent(order));
    }
}
