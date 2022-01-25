package com.japhy.cloud.order.domain.repository;

import com.japhy.cloud.order.domain.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Japhy
 * @since 2022/1/18 10:39
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, String> {

    Optional<Order> findByOrderId(Integer orderId);

    List<Order> queryByOrderNameLike(String orderName);
}
