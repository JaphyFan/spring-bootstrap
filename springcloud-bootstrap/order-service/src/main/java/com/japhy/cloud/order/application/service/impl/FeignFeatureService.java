package com.japhy.cloud.order.application.service.impl;

import com.japhy.cloud.order.application.dto.UserDto;
import com.japhy.cloud.order.application.service.FeatureService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Japhy
 * @since 2022/1/21 16:34
 */
@FeignClient(value = "user-service", fallback = FeignFeatureServiceFallback.class)
public interface FeignFeatureService extends FeatureService {

    @Override
    @RequestMapping("/api/v1/features/delay/{time}")
    @Retry(name = "user")
//    @TimeLimiter(name = "user")
    @CircuitBreaker(name = "user")
    List<UserDto> delay(@PathVariable("time") long timeInSec);
}
