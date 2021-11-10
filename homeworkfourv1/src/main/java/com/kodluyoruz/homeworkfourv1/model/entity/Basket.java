package com.kodluyoruz.homeworkfourv1.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "baskets")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY, mappedBy = "basket")
    private List<BasketItem> basketItemList;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;

    @Builder.Default
    private Boolean isBasketActive = true;





}
