package com.kodluyoruz.homeworkfourv1.controller;


import com.kodluyoruz.homeworkfourv1.model.dto.BasketDto;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateBasketRequest;
import com.kodluyoruz.homeworkfourv1.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("baskets")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BasketDto createBasket(@RequestBody CreateUpdateBasketRequest request) {
        return service.createBasket(request);
    }

    @GetMapping("{id}")
    public BasketDto getBasket(@PathVariable int id) {
        return service.getBasket(id);
    }

    @PutMapping("{id}")
    public BasketDto updateBasket(@PathVariable int id,@RequestBody CreateUpdateBasketRequest request){
        return service.updateBasket(id,request);
    }

}





