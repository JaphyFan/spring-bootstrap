package com.japhy.bootstrap.web.interfaces.http;

import com.japhy.bootstrap.web.application.converter.OrderMapper;
import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.domain.order.model.vo.OrderParam;
import com.japhy.bootstrap.web.domain.order.service.OrderService;
import com.japhy.bootstrap.web.interfaces.dto.OrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/8 13:58
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@Tag(name = "订单")
public class OrderApi {

    private final OrderService orderService;

    @Operation(summary = "find order by id ", description = "http get method to find order by id, if not found, return http status code 404.")
    @GetMapping("{id}")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<OrderDto> findById(@PathVariable("id") Long id) {
        Optional<Order> order = orderService.queryOrderById(id);
        return order.map(value -> ResponseEntity.ok(OrderMapper.INSTANCE.orderToOrderDto(value)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "query order")
    @GetMapping
    @RolesAllowed("ADMIN")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<List<OrderDto>> queryOrder(OrderParam orderParam) {
        orderService.queryOrder(orderParam);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "delete order")
    @DeleteMapping("{id}")
    @SecurityRequirement(name = "bearer-key")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "update order")
    @PutMapping("{id}")
    @RolesAllowed("ROLE_ADMIN")
    @SecurityRequirement(name = "bearer-key")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long id) {
        orderService.updateOrder(order);
        return ResponseEntity.ok(order);
    }

    @Operation(summary = "update order")
    @PatchMapping("{id}")
    public ResponseEntity<Order> patchOrder(@RequestBody Order order, @PathVariable Long id) {
        orderService.updateOrder(order);
        return ResponseEntity.ok(order);
    }

    @Operation(summary = "create order")
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDto order) {
        OrderMapper orderMapper = OrderMapper.INSTANCE;
        Order order1 = orderService.saveOrder(orderMapper.orderDtoToOrder(order));
        return ResponseEntity.created(URI.create("/api/v1/orders/" + order1.getId())).body(order1);
    }

    @Operation(summary = "get order ")
    @GetMapping("/name")
    public ResponseEntity<String> getOrder(@RequestParam String name) {
        return ResponseEntity.ok(name);
    }

}
