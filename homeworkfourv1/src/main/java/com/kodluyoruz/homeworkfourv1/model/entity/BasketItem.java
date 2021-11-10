package com.kodluyoruz.homeworkfourv1.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "basketItems")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketItem extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "basket_id")
    private Integer basketId;

    @Column(name = "product_id")
    private Integer productId;

    @NotNull
    @Min(1)
    private Integer quantity;

    @ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id", nullable = false, insertable = false, updatable = false)
    private Basket basket;

    @ManyToOne()
    @JoinColumn(name = "product_id",nullable = false,updatable = false,insertable = false)
    private Product product;



}
