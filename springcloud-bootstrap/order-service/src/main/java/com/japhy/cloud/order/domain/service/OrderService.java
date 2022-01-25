package com.japhy.cloud.order.domain.service;

import com.japhy.cloud.order.domain.entity.Order;
import java.util.List;
import java.util.Optional;

/**
 * @author Japhy
 * @since 2022/1/18 13:50
 */
public interface OrderService {

    Optional<Order> findByOrderId(Integer orderId);

    List<Order> queryByOrderNameLike(String orderName);
}
