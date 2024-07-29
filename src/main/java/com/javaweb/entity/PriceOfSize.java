package com.javaweb.entity;

import javax.persistence.*;
import lombok.*;
@Setter
@Getter
@Table(name = "price_of_size")
@Entity
public class PriceOfSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "size_l")
    private Double sizeL;
    @Column(name = "size_m")
    private Double sizeM;

    @OneToOne(mappedBy = "priceOfSize")
    private Product product;
}
