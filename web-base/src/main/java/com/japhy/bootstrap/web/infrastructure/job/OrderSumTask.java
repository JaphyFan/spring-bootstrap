package com.japhy.bootstrap.web.infrastructure.job;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.domain.order.repository.OrderRepository;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Japhy
 * @since 2021/1/24 21:19
 */
@Component
@Slf4j
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "cron")
public class OrderSumTask {

    private final OrderRepository orderRepository;

    @Async
    @Scheduled(cron = "0/100 * * * * ?")
    @Transactional(propagation = Propagation.REQUIRED)
    public void sumOrder() {
        try {
            Optional<Order> byId = orderRepository.findById(1L);

            if (byId.isPresent()) {
                log.info("sum order get lock -----");
            } else {
                log.error("sum order dont get lock");
            }

            TimeUnit.SECONDS.sleep(2);
            log.info("sum order release --- lock");

        } catch (Exception e) {

        }
    }

    @Async
    @Scheduled(cron = "0/100 * * * * ?")
    @Transactional(propagation = Propagation.REQUIRED)
    public void sumOrder2() {

        try {
            Optional<Order> byId = orderRepository.findById(1L);

            if (byId.isPresent()) {
                log.info("sum order22222222 get lock -----");
            } else {
                log.error("sum2222222222 order dont get lock");
            }
            TimeUnit.SECONDS.sleep(2);
            log.info("sum2222222222 order release --- lock");
        } catch (Exception e) {
            log.error("sum2222222222 order dont get lock");
        }

    }
}
