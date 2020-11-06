package com.japhy.action.domain.taco.model.entity;

import java.util.Date;
import lombok.Data;

/**
 * @author Japhy
 * @since 2020/7/6 15:26
 */
@Data
public class Order {

    private Long id;

    private Date createTime;

}
