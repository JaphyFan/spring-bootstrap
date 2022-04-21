package com.japhy.bootstrap.web.domain.order.repository;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import java.util.Optional;
import javax.persistence.LockModeType;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Japhy
 * @since 2021/1/8 16:34
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByOrderNo(String orderNo);

    /**
     * 悲观锁实现.
     * 类似 select for update.
     *
     * @param id
     * @return
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Order> findById(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "insert into web_order (`id`) values (:id) on duplicate key update id = :id")
    int insertOnDuplicateKey(Long id);
}
