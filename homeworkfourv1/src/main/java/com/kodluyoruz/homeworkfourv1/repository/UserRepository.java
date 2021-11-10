package com.kodluyoruz.homeworkfourv1.repository;

import com.kodluyoruz.homeworkfourv1.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
