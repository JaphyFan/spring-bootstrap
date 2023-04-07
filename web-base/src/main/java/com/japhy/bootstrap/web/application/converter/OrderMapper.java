package com.japhy.bootstrap.web.application.converter;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.interfaces.dto.OrderDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Japhy
 * @since 2021/2/3 18:41
 */
@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto orderToOrderDto(Order order);

    List<OrderDto> toOrderDtoList(List<Order> orderList);

    Order orderDtoToOrder(OrderDto order);
}
