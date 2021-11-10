package com.kodluyoruz.homeworkfourv1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutDto {

    private int userId;
    private int basketId;
    private List<BasketItemDto> basketItemList;

}
