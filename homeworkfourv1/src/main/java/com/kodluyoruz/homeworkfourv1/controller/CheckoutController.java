package com.kodluyoruz.homeworkfourv1.controller;

import com.kodluyoruz.homeworkfourv1.model.dto.CheckoutDto;
import com.kodluyoruz.homeworkfourv1.model.dto.OrderDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Basket;
import com.kodluyoruz.homeworkfourv1.model.entity.BasketItem;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateOrderRequest;
import com.kodluyoruz.homeworkfourv1.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("checkouts")
public class CheckoutController {
    private final CheckoutService service;


    @GetMapping("{userId}")
    public CheckoutDto getBasketItems(@PathVariable int userId) {
        return service.getBasketItems(userId);
    }

    @PostMapping("{basketId}")
    public OrderDto createOrder(@PathVariable int basketId, CreateUpdateOrderRequest request){
        return  service.createOrder(basketId,request) ;
    }


}
