package com.kodluyoruz.homeworkfourv1.mapper;

import com.kodluyoruz.homeworkfourv1.model.dto.BasketDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Basket;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateBasketRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface BasketMapper {

    BasketMapper BASKET_MAPPER = Mappers.getMapper(BasketMapper.class);

    Basket createBasket(CreateUpdateBasketRequest request);

    BasketDto toBasketDto(Basket basket);

    List<BasketDto> toBasketDtoList(List<Basket> baskets);

    void updateProduct(@MappingTarget Basket basket, CreateUpdateBasketRequest request);

    void addItemtoBasket(@MappingTarget Basket basket, AddProductRequest request);
}
