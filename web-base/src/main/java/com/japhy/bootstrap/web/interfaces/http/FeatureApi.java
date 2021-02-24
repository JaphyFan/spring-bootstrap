package com.japhy.bootstrap.web.interfaces.http;

import com.japhy.bootstrap.web.application.mapper.OrderMapper;
import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.interfaces.dto.OrderDto;
import io.swagger.annotations.Api;
import java.util.Date;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/1/25 16:48
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/features")
@Api("demonstrate some features")
public class FeatureApi {

    private final OrderMapper orderMapper;

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

}
