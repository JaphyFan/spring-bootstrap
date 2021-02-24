package com.japhy.bootstrap.web.application.mapper;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.interfaces.dto.OrderDto;
import org.mapstruct.Mapper;

/**
 * @author Japhy
 * @since 2021/2/3 18:41
 */
@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto orderToOrderDto(Order order);
}
