package com.javaweb.entity;


import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "`order`")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "current_price")
    private double currentPrice;
    @Column(name = "sugar")
    private String sugar;
    @Column(name = "current_total")
    private double totalCurrent;
    @Column(name = "status")
    private Boolean status;

    //mapping
    @ManyToMany(mappedBy = "orderList", fetch = FetchType.LAZY)
    private List<Topping> toppingList  = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_detail_order")
    private DetailOrder detailOrder;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

}
