package com.japhy.bootstrap.web.application.event.subscriber;

import com.japhy.bootstrap.web.domain.order.event.OrderCreatedEvent;
import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2021/3/4 17:30
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class OrderUpdatedSubscriber {

    @EventListener
    public Future<Order> subscribe(OrderCreatedEvent orderCreatedEvent)
        throws InterruptedException {
        log.info("Thread---------" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(1L);
        return new AsyncResult<>(orderCreatedEvent.getOrder());
    }
}
