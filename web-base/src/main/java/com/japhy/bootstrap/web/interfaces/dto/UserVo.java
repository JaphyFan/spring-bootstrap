package com.japhy.bootstrap.web.interfaces.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

/**
 * @author Japhy
 * @since 2021/1/30 14:52
 */
@Data
@Builder
public class UserVo {

    private String jwtToken;

    @Singular
    private List<OrderDto> orderDtos;

}
