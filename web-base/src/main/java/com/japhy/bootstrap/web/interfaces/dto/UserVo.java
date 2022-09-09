package com.japhy.bootstrap.web.interfaces.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.JsonParser;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

/**
 * @author Japhy
 * @since 2021/1/30 14:52
 */
@Data
@Builder
@JsonDeserialize()
public class UserVo {

    private String jwtToken;

    @Singular
    private List<OrderDto> orderDtos;

}
