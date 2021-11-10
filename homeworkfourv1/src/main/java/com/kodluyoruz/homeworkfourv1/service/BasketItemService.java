package com.kodluyoruz.homeworkfourv1.service;

import com.kodluyoruz.homeworkfourv1.model.dto.BasketDto;
import com.kodluyoruz.homeworkfourv1.model.dto.BasketItemDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Basket;
import com.kodluyoruz.homeworkfourv1.model.entity.BasketItem;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateBasketItemRequest;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateBasketRequest;
import com.kodluyoruz.homeworkfourv1.repository.BasketItemRepository;
import com.kodluyoruz.homeworkfourv1.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodluyoruz.homeworkfourv1.mapper.BasketItemMapper.BASKET_ITEM_MAPPER;

@Service
@RequiredArgsConstructor
public class BasketItemService {
    private final BasketItemRepository repository;
    private final BasketRepository basketRepository;

    public BasketItemDto createBasket(CreateUpdateBasketItemRequest request) {

        BasketItem basketItem = BASKET_ITEM_MAPPER.createBasketItem(request);
        return BASKET_ITEM_MAPPER.toBasketItemDto(repository.save(basketItem));

    }


    public List<BasketItemDto> getBasketItems(int id) {
        Basket basket = basketRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return BASKET_ITEM_MAPPER.toBasketItemDtoList(basket.getBasketItemList());

    }
}
