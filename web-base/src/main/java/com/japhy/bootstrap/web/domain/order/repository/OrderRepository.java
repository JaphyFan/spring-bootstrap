package com.japhy.bootstrap.web.domain.order.repository;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Japhy
 * @since 2021/1/8 16:34
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderNo(String orderNo);
}
