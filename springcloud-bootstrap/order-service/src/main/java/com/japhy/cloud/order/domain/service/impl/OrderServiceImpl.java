package com.japhy.cloud.order.domain.service.impl;

import com.japhy.cloud.order.domain.entity.Order;
import com.japhy.cloud.order.domain.repository.OrderRepository;
import com.japhy.cloud.order.domain.service.OrderService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2022/1/18 13:51
 */
@Service
@Slf4j
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> findByOrderId(Integer orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public List<Order> queryByOrderNameLike(String orderName) {
        return orderRepository.queryByOrderNameLike(orderName);
    }
}
