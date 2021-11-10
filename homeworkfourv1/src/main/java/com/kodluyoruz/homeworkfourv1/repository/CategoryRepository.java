package com.kodluyoruz.homeworkfourv1.repository;

import com.kodluyoruz.homeworkfourv1.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
