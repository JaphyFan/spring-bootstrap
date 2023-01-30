package com.japhy.bootstrap.web.infrastructure.job;

import com.japhy.bootstrap.web.domain.order.repository.OrderRepository;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Japhy
 * @since 2022/4/8 17:52
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class PermissionLockJob {

    private final OrderRepository orderRepository;

    private final JdbcTemplate jdbcTemplate;

    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void sumOrder() {
        try {
            // 使用jpa无法获取到mysql返回的值0，1，2
            // Query nativeQuery = entityManager.createNativeQuery(
            //         "insert into web_order (`id`) values (:id) on duplicate key update id = :id");
            // nativeQuery.setParameter("id", 5);
            // int i = nativeQuery.executeUpdate();
            // int num = orderRepository.insertOnDuplicateKey(5L);
            int update = jdbcTemplate.update(
                    "insert into web_order (`id`) values (?) on duplicate key update id = ?", 5, 5);
            if (update > 0) {
                log.info("sum order get lock -----");
            } else {
                log.error("sum order dont get lock");
            }

            TimeUnit.SECONDS.sleep(2);
            log.info("sum order release --- lock");

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public void sumOrder2() {
        try {
            int update = jdbcTemplate.update(
                    "insert into web_order (`id`) values (?) on duplicate key update id = ?", 5, 5);
            if (update > 0) {
                log.info("sum sumOrder2 get lock -----");
            } else {
                log.error("sum sumOrder2 dont get lock");
            }

            TimeUnit.SECONDS.sleep(2);
            log.info("sum sumOrder2 release --- lock");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
