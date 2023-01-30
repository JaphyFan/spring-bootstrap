package com.japhy.bootstrap.web.interfaces.http;

import com.japhy.bootstrap.web.application.event.publisher.OrderCreatedEventPublisher;
import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.infrastructure.annotations.LogExecutionTime;
import com.japhy.bootstrap.web.interfaces.dto.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/25 16:48
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/features")
@Tag(name = "demonstrate some features")
public class FeatureApi {

    @Setter
    private OrderCreatedEventPublisher publisher;

    @GetMapping("/filter")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/docker")
    public ResponseEntity<String> docker() {
        return ResponseEntity.ok("docker start");
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/roles")
    public ResponseEntity<String> role() {
        return ResponseEntity.ok("admin role test");
    }

    @LogExecutionTime
    @Operation(summary = "test get array param", description = "@RequestParam will automatically split dot separated string")
    @GetMapping("/testArray")
    ResponseEntity<List<String>> testArray(@Parameter @RequestParam List<String> orderNos) {
        UserVo.builder().jwtToken("d").build();
        return ResponseEntity.ok(orderNos);
    }

    @GetMapping("/async")
    public ResponseEntity<String> async() {
        publisher.publishEvent(new Order());
        return ResponseEntity.ok("async test");
    }

    @GetMapping("/optional")
    public ResponseEntity<String> optional(@Parameter @RequestParam(required = false) String test) {
        return ResponseEntity.ok(test);
    }
}
