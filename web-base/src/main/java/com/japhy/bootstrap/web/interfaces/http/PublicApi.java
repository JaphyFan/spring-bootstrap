package com.japhy.bootstrap.web.interfaces.http;

import com.japhy.bootstrap.web.application.mapper.OrderMapper;
import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.interfaces.dto.OrderDto;
import io.swagger.annotations.Api;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/3/1 10:08
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/public/v1/features")
@Api("demonstrate some public features")
public class PublicApi {

    @GetMapping("/mapper")
    public ResponseEntity<OrderDto> mapper() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.now();
        Order order =
            Order.builder().createTime(localDateTime).id(1L).operatorId(1L).orderNo("no").status(1)
                .updateTime(date).userId(1L).build();
        return ResponseEntity.ok(OrderMapper.INSTANCE.orderToOrderDto(order));
    }
}
