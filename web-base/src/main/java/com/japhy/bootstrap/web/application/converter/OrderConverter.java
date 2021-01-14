package com.japhy.bootstrap.web.application.converter;

import com.japhy.bootstrap.web.domain.order.model.entity.Order;
import com.japhy.bootstrap.web.infrastructure.util.Converter;
import com.japhy.bootstrap.web.interfaces.dto.OrderDto;

/**
 * @author Japhy
 * @since 2021/1/12 10:06
 */
public class OrderConverter extends Converter<Order, OrderDto> {

    public OrderConverter() {
        super(OrderConverter::toDto, OrderConverter::toEntity);
    }

    public static OrderDto toDto(Order order) {
        return OrderDto.builder().orderNo(order.getOrderNo()).id(order.getId())
            .status(order.getStatus()).build();
    }

    public static Order toEntity(OrderDto orderDto) {
        return Order.builder().orderNo(orderDto.getOrderNo()).id(orderDto.getId())
            .status(orderDto.getStatus()).build();
    }
}
