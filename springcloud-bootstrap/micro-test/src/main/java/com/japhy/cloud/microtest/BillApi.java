package com.japhy.cloud.microtest;

import com.japhy.cloud.microtest.remote.BasicOrderService;
import com.japhy.cloud.microtest.remote.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/11/1 18:10
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class BillApi {

    private final OrderService orderService;

    private final BasicOrderService basicOrderService;

    @GetMapping("/api/v1/bills/order1")
    public ResponseEntity<?> order1() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/api/v1/bills/order2")
    public ResponseEntity<?> order2() {
        return ResponseEntity.ok(basicOrderService.getOrders());
    }
}
