package com.kodluyoruz.homeworkfourv1.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateBasketItemRequest {
    private int productId;
    private int quantity;
    private int basketId;
}
