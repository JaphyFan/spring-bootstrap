package com.japhy.bootstrap.web.application.event.subscriber;

import com.japhy.bootstrap.web.domain.order.event.OrderCreatedEvent;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
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
    @Async
    public String subscribe(OrderCreatedEvent orderCreatedEvent) throws InterruptedException {
        log.info("thread name is " + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(10L);
        log.info(orderCreatedEvent + "===========================sleep over");
        return orderCreatedEvent.getOrder().getOrderNo();
    }

}
