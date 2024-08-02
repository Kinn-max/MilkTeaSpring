package com.javaweb.entity;


import lombok.*;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "detail_order")
@Entity
public class DetailOrder extends DateOfCommon{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_detail_order")
    private String codeDetailOrder;
    @Column(name = "code_voucher")
    private String codeVoucher;
    @Column(name = "total_price")
    private double totalPrice;
    @Column(name = "quantity_product")
    private int quantityProduct;
    @Column(name = "status")
    private String status;
    @Column(name = "payment")
    private String payment;
    @Column(name = "note")
    private String note;
    @Column(name = "delivery")
    private String delivery;
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "phone_receiver")
    private String phoneReceiver;
    @Column(name = "address_receiver")
    private String addressReceiver;

    // mapping
    @OneToMany(mappedBy = "detailOrder", fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE}, orphanRemoval = true)
    private List<Order> orderList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
