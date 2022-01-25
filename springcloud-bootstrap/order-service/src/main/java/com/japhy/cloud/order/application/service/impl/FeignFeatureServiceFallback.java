package com.japhy.cloud.order.application.service.impl;

import com.google.common.collect.Lists;
import com.japhy.cloud.order.application.dto.UserDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Japhy
 * @since 2022/1/22 19:22
 */
@Component
@Slf4j
public class FeignFeatureServiceFallback implements FeignFeatureService {

    @Override
    public List<UserDto> delay(long timeInSec) {
        UserDto build = UserDto.builder().name(String.valueOf(timeInSec)).build();
        return Lists.newArrayList(build);
    }
}
