package com.japhy.bootstrap.web.domain.order.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Japhy
 * @since 2021/1/10 20:48
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderParam{

    private String orderNo;
}
