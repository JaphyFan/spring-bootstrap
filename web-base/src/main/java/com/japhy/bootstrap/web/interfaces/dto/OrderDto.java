package com.japhy.bootstrap.web.interfaces.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Japhy
 * @since 2021/1/11 15:23
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class OrderDto {

    public Long id;

    private String orderNo;

    private Long userId;

    private Date createTime;

    private Date updateTime;

    private Long operatorId;

    private Integer status;
}
