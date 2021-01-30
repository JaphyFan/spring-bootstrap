package com.japhy.bootstrap.web.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Japhy
 * @since 2021/1/30 14:52
 */
@Builder
@AllArgsConstructor
@Data
public class UserVo {

    private String jwtToken;
}
