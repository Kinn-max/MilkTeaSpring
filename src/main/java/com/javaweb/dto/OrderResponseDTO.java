package com.javaweb.dto;

import com.javaweb.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDTO {
    private Long id;
    private int quantity;
    private double currentPrice;
    private String sugar;
    private double totalCurrent;
    private String nameTopping;
    private ProductDTO product;
}
