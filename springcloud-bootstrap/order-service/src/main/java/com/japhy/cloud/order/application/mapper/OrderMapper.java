package com.japhy.cloud.order.application.mapper;

import com.japhy.cloud.order.application.dto.OrderDto;
import com.japhy.cloud.order.domain.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Japhy
 * @since 2022/1/18 14:02
 */
@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto entityToDto(Order order);

}
