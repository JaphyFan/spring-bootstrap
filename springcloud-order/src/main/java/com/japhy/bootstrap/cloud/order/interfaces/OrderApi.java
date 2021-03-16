package com.japhy.bootstrap.cloud.order.interfaces;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Japhy
 * @since 2021/3/16 14:09
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@Api("cloud-order")
public class OrderApi {

    @GetMapping("/v1/orders")
    @ApiOperation("获取全部订单")
    public ResponseEntity<List<String>> getOrders() {
        return ResponseEntity.ok(Lists.newArrayList("order1", "order2"));
    }

}
