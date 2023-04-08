package com.japhy.bootstrap.web.domain.order.service.impl;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.domain.order.model.vo.OrderParam;
import com.japhy.bootstrap.web.domain.order.repository.OrderRepository;
import com.japhy.bootstrap.web.domain.order.service.OrderService;
import com.japhy.bootstrap.web.infrastructure.annotations.LogExecutionTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2021/1/8 17:32
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    @RolesAllowed("ADMIN")
    public Optional<Order> queryOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> queryOrder(OrderParam orderParam) {
        return null;
    }

    @Override
    @Async
    public Future<Order> asyncGetOrderById(Long id) throws InterruptedException {
        log.info("thread name is ------------dsfjlsjdlfjsldjf;sj;jlsjdfsdsjldjljfs;jf;sf-----" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(10L);
        return new AsyncResult<>(Order.builder().orderNo("orderNo").build());
    }

    @Override
    @LogExecutionTime
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
    }

    @Override
    public void updateOrder(Order order) {

    }
}
