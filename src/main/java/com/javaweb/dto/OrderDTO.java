package com.javaweb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long id;
    private int quantity;//
    private double currentPrice;//
    private String sugar;//
    private double totalCurrent;
    private List<Long> toppingList;//
    private Long idProduct;//
}
