package com.japhy.cloud.microtest.remote;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Japhy
 * @since 2021/3/17 17:10
 */
@FeignClient(value = "order-service2", url = "${order.service.url:}")
public interface BasicOrderService {

    @RequestMapping("/api/v1/orders")
    List<String> getOrders();
}
