package com.kodluyoruz.homeworkfourv1.controller;
import com.kodluyoruz.homeworkfourv1.model.dto.BasketItemDto;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateBasketItemRequest;
import com.kodluyoruz.homeworkfourv1.service.BasketItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("basket_items")
public class BasketItemController {
    private final BasketItemService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BasketItemDto createBasket(@RequestBody CreateUpdateBasketItemRequest request) {
        return service.createBasket(request);
    }

    @GetMapping("{id}")
    public List<BasketItemDto> getBasketItems(@PathVariable int id){
        return service.getBasketItems(id);
    }


}
