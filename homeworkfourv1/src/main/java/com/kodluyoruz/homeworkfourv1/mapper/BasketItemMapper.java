package com.kodluyoruz.homeworkfourv1.mapper;

import com.kodluyoruz.homeworkfourv1.model.dto.BasketDto;
import com.kodluyoruz.homeworkfourv1.model.dto.BasketItemDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Basket;
import com.kodluyoruz.homeworkfourv1.model.entity.BasketItem;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateBasketItemRequest;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateBasketRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface BasketItemMapper {
    BasketItemMapper BASKET_ITEM_MAPPER= Mappers.getMapper(BasketItemMapper.class);

    BasketItem createBasketItem(CreateUpdateBasketItemRequest request);

    List<BasketItemDto> toBasketItemDtoList(List<BasketItem> basketItems);

    void updateProduct(@MappingTarget BasketItem basketItem, CreateUpdateBasketItemRequest request);

    BasketItemDto toBasketItemDto(BasketItem basketItem);
}
