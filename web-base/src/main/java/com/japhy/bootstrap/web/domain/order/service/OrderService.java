package com.japhy.bootstrap.web.domain.order.service;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.domain.order.model.vo.OrderParam;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

/**
 * @author Japhy
 * @since 2021/1/8 17:32
 */
public interface OrderService {

    Optional<Order> queryOrderById(Long id);

    List<Order> queryOrder(OrderParam orderParam);

    Order saveOrder(Order order);

    void deleteOrder(Long id);

    void updateOrder(Order order);

    Future<Order> asyncGetOrderById(Long id) throws InterruptedException;

}
