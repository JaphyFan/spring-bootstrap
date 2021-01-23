package com.japhy.bootstrap.web.interfaces.http;

import com.japhy.bootstrap.web.application.converter.OrderConverter;
import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.domain.order.model.vo.OrderParam;
import com.japhy.bootstrap.web.domain.order.service.OrderService;
import com.japhy.bootstrap.web.infrastructure.annotations.LogExecutionTime;
import com.japhy.bootstrap.web.infrastructure.util.Converter;
import com.japhy.bootstrap.web.interfaces.dto.OrderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
@Api("订单")
public class OrderApi {

    private final OrderService orderService;

    @ApiOperation(value = "find order by id ", notes = "http get method to find order by id, if not found, return http status code 404.")
    @GetMapping("{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable("id") Long id) {
        Optional<Order> order = orderService.queryOrderById(id);
        Converter<Order, OrderDto> converter = new OrderConverter();
        return order.map(value -> ResponseEntity.ok(converter.fromEntity(value)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "query order")
    @GetMapping
    public ResponseEntity<List<OrderDto>> queryOrder(OrderParam orderParam) {
        orderService.queryOrder(orderParam);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "delete order")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "update order")
    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long id) {
        orderService.updateOrder(order);
        return ResponseEntity.ok(order);
    }

    @ApiOperation(value = "update order")
    @PatchMapping("{id}")
    public ResponseEntity<Order> patchOrder(@RequestBody Order order, @PathVariable Long id) {
        orderService.updateOrder(order);
        return ResponseEntity.ok(order);
    }

    @ApiOperation(value = "create order")
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order order1 = orderService.saveOrder(order);
        return ResponseEntity.created(URI.create("/api/v1/orders/" + order1.getId())).body(order1);
    }

    @LogExecutionTime
    @ApiOperation(value = "test get array param", notes = "@RequestParam will automatically split dot separated string")
    @GetMapping("/testArray")
    ResponseEntity<List<String>> testArray(@RequestParam List<String> orderNos) {
        return ResponseEntity.ok(orderNos);
    }
}
