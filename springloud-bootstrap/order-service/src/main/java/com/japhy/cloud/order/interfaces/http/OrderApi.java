package com.japhy.cloud.order.interfaces.http;

import com.google.common.collect.Lists;
import com.japhy.cloud.order.domain.entity.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.awt.print.Pageable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2022/1/17 17:42
 */
@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
@Tag(name = "订单接口")
@Slf4j
public class OrderApi {

    @GetMapping("/{id}")
    @Operation(summary = "order service", description = "find order by id")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<Order> getOrderById(
            @Parameter(name = "order id", required = true) @PathVariable Long orderId) {
//        Order order = orderService.getById(orderId);
        return ResponseEntity.ok(null);
    }

    @GetMapping
    @Operation(summary = "order service", description = "find order by name pattern")
    @ApiResponse(responseCode = "200")
    public ResponseEntity<List<Order>> queryOrderByName(
            @Parameter(name = "name pattern", required = true, example = "aa,ab,ac")
            @RequestParam String name, Pageable pageable) {
//        List<Order> orders = orderService.queryByName(name);
        return ResponseEntity.ok(Lists.newArrayList());
    }
}
