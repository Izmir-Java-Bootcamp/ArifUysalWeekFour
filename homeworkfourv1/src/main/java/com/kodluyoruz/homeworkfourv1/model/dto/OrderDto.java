package com.kodluyoruz.homeworkfourv1.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto {

    private Integer id;
    private Integer userId;

}