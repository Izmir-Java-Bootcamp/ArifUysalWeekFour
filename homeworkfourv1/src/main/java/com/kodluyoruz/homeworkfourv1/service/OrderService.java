package com.kodluyoruz.homeworkfourv1.service;

import com.kodluyoruz.homeworkfourv1.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository repository;


}