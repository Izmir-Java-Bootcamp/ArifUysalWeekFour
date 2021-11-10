package com.kodluyoruz.homeworkfourv1.repository;


import com.kodluyoruz.homeworkfourv1.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
