package com.japhy.bootstrap.cloud.bill.application.remote;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Japhy
 * @since 2021/3/16 15:41
 */
@FeignClient(value = "order-service")
public interface OrderService {

    @RequestMapping("/api/v1/orders")
    List<String> getOrders();

}
