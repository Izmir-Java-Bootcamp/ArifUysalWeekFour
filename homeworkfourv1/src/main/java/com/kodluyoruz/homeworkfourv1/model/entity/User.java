package com.kodluyoruz.homeworkfourv1.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 3)
    private String userName;

    @NotBlank
    @Size(min = 4)
    @Column(unique = true)
    private String ssn;

    @OneToMany(cascade = CascadeType.ALL, fetch =  FetchType.LAZY,mappedBy = "user")
    private List<Basket> basket;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Order> orderList;








}
