package com.japhy.cloud.order.application.service;

import com.japhy.cloud.order.application.dto.UserDto;
import java.util.List;

/**
 * @author Japhy
 * @since 2022/1/22 19:19
 */
public interface FeatureService {

    List<UserDto> delay(long timeInSec);
}
