package com.kodluyoruz.homeworkfourv1.service;

import com.kodluyoruz.homeworkfourv1.model.dto.BasketDto;
import com.kodluyoruz.homeworkfourv1.model.dto.ProductDto;
import com.kodluyoruz.homeworkfourv1.model.entity.Basket;
import com.kodluyoruz.homeworkfourv1.model.entity.Product;

import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateBasketRequest;
import com.kodluyoruz.homeworkfourv1.model.request.CreateUpdateProductRequest;
import com.kodluyoruz.homeworkfourv1.repository.BasketRepository;
import com.kodluyoruz.homeworkfourv1.repository.ProductRepository;
import com.kodluyoruz.homeworkfourv1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.kodluyoruz.homeworkfourv1.mapper.BasketMapper.BASKET_MAPPER;
import static com.kodluyoruz.homeworkfourv1.mapper.ProductMapper.PRODUCT_MAPPER;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository repository;


    public BasketDto createBasket(CreateUpdateBasketRequest request) {
        if (repository.findBasketByUserIdAndIsBasketActive(request.getUserId(),true)){
            throw new RuntimeException("Active basket for this User!");
        }
        else {
        Basket basket = BASKET_MAPPER.createBasket(request);
        return BASKET_MAPPER.toBasketDto(repository.save(basket));
        }
    }

    public Basket getBasketEntity(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Basket can not found"));
    }

    public BasketDto getBasket(int id) {
        Basket basket = getBasketEntity(id);
        return BASKET_MAPPER.toBasketDto(basket);
    }

    public BasketDto updateBasket(int id, CreateUpdateBasketRequest request) {
        Basket basket = getBasketEntity(id);
        BASKET_MAPPER.updateProduct(basket,request);
        Basket updatedBasket = repository.save(basket);
        return BASKET_MAPPER.toBasketDto(updatedBasket);
    }
}