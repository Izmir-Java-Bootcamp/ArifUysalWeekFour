package com.kodluyoruz.homeworkfourv1.mapper;


import com.kodluyoruz.homeworkfourv1.model.dto.OrderDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Order;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDtoList(List<Order> orderList);

    Order createOrder(CreateUpdateOrderRequest request);

    void updateProduct(@MappingTarget Order order, CreateUpdateOrderRequest request);
}
