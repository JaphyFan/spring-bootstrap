package com.japhy.cloud.order.application.service.impl;

import com.japhy.cloud.common.exceptions.NotFoundException;
import com.japhy.cloud.order.application.dto.OrderDto;
import com.japhy.cloud.order.application.mapper.OrderMapper;
import com.japhy.cloud.order.application.service.OrderFacade;
import com.japhy.cloud.order.domain.entity.Order;
import com.japhy.cloud.order.domain.service.OrderService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2022/1/18 14:05
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderFacadeImpl implements OrderFacade {

    private final OrderService orderService;

    @Override
    public OrderDto findByOrderId(Integer orderId) {
        Optional<Order> byOrderId = orderService.findByOrderId(orderId);
        Order order = byOrderId.orElseThrow(
                () -> new NotFoundException("No Order Found for orderId: " + orderId));
        OrderMapper instance = OrderMapper.INSTANCE;
        return instance.entityToDto(order);
    }
}
