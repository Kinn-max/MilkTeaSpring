package com.javaweb.entity;

import javax.persistence.*;
import lombok.*;

@Setter
@Getter
@Table(name = "voucher")
@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "discount")
    private double discount;

}
