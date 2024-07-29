package com.javaweb.entity;

import javax.persistence.*;
import lombok.*;
import javax.persistence.*;

@Setter
@Getter
@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "id_price")
    private PriceOfSize priceOfSize;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "product")
    private Order order;

}
