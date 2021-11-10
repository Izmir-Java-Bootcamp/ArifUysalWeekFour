package com.kodluyoruz.homeworkfourv1.repository;

import com.kodluyoruz.homeworkfourv1.model.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout,Integer> {
}
