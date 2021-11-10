package com.kodluyoruz.homeworkfourv1.repository;

import com.kodluyoruz.homeworkfourv1.model.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BasketRepository extends JpaRepository<Basket,Integer> {
        boolean findBasketByUserIdAndIsBasketActive(int userId, boolean isBasketActive);
}
