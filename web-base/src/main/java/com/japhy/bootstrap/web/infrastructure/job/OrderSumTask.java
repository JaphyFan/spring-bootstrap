package com.japhy.bootstrap.web.infrastructure.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2021/1/24 21:19
 */
@Component
@Slf4j
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "cron")
public class OrderSumTask {

    @Async
    @Scheduled(cron = "0/2 * * * * ?")
    public void sumOrder() {
        log.info("order si summing");
    }
}
