package com.javaweb.entity;


import javax.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "topping")
@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "order_topping",
                joinColumns = @JoinColumn(name = "topping_id",nullable = false),
                inverseJoinColumns = @JoinColumn(name = "order_id", nullable = false))
    private List<Order> orderList = new ArrayList<>();
}