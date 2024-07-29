package com.javaweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private String image;
    private Double priceL;
    private Double priceM;
    private String nameCategory;
}
