package com.japhy.cloud.order.application.service;

import com.japhy.cloud.order.application.dto.OrderDto;
import com.japhy.cloud.order.domain.entity.Order;
import java.util.Optional;

/**
 * @author Japhy
 * @since 2022/1/18 14:04
 */
public interface OrderFacade {

    OrderDto findByOrderId(Integer orderId);
}
