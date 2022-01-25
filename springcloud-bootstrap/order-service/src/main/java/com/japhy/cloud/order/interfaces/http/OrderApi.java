package com.japhy.cloud.order.interfaces.http;

import com.google.common.collect.Lists;
import com.japhy.cloud.order.application.dto.OrderDto;
import com.japhy.cloud.order.application.service.OrderFacade;
import com.japhy.cloud.order.domain.entity.Order;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.awt.print.Pageable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private final OrderFacade orderFacade;

    @GetMapping("/v1/orders")
    @Operation(summary = "获取全部订单")
    public ResponseEntity<List<String>> getOrders() {
        return ResponseEntity.ok(Lists.newArrayList("order1", "order2"));
    }

    @PostMapping("/v1/orders")
    @Operation(summary = "获取全部订单")
    public ResponseEntity<List<String>> updateOrder(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(Lists.newArrayList("order1", "order2"));
    }

    @GetMapping("/{orderId}")
    @Operation(summary = "order service", description = "find order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ok"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Not found")})
    public ResponseEntity<OrderDto> getOrderByOrderId(@Value("${custom.name}") String name,
            @Parameter(name = "order id", required = true) @PathVariable Integer orderId) {
        System.out.println("great name :" + name);
        OrderDto byOrderId = orderFacade.findByOrderId(orderId);
        return ResponseEntity.ok(byOrderId);
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
