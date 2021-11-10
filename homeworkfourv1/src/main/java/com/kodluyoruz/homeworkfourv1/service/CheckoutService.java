package com.kodluyoruz.homeworkfourv1.service;

import com.kodluyoruz.homeworkfourv1.model.dto.BasketItemDto;
import com.kodluyoruz.homeworkfourv1.model.dto.CheckoutDto;
import com.kodluyoruz.homeworkfourv1.model.dto.OrderDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Basket;
import com.kodluyoruz.homeworkfourv1.model.entity.BasketItem;
import com.kodluyoruz.homeworkfourv1.model.entity.Order;
import com.kodluyoruz.homeworkfourv1.model.entity.Product;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateOrderRequest;
import com.kodluyoruz.homeworkfourv1.repository.BasketItemRepository;
import com.kodluyoruz.homeworkfourv1.repository.BasketRepository;
import com.kodluyoruz.homeworkfourv1.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.kodluyoruz.homeworkfourv1.mapper.OrderMapper.ORDER_MAPPER;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    private final BasketItemService basketItemService;
    private final BasketRepository basketRepository;
    private final OrderRepository repository;


    public CheckoutDto getBasketItems(int userId) {
        Basket basket = basketRepository.findById(userId).orElseThrow(() -> new RuntimeException("Not found!"));
        List<BasketItemDto> basketItemList = getBasketItemList(basket);
        return CheckoutDto.builder()
                .basketId(basket.getId())
                .userId(userId)
                .basketItemList(basketItemList)
                .build();

    }
    public List<BasketItemDto> getBasketItemList(Basket basket) {
        return basketItemService.getBasketItems(basket.getId());

    }
    public OrderDto createOrder(int basketId, CreateUpdateOrderRequest request) {
        Basket basket = basketRepository.findById(basketId).orElseThrow(() -> new RuntimeException("Not found!"));
        totalPrices(basket);
        Order order = ORDER_MAPPER.createOrder(request);
        order.setTotalPrice(totalPrices(basket));
        order.setQuantity(1);
        order.setUnitPrice(3.0);

        return ORDER_MAPPER.toOrderDto(repository.save(order));


    }
    private double totalPrices(Basket basket){
        double total = 0;
        for (int i = 0 ; i < basket.getBasketItemList().size(); i++){
            total = total + basket.getBasketItemList().get(i).getProduct().getPrice()*basket.getBasketItemList().get(i).getQuantity();
        }
        return total;
    }
}