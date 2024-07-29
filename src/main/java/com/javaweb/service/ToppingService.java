package com.javaweb.service;

import com.javaweb.dto.ToppingDTO;
import com.javaweb.entity.Topping;

import java.util.List;

public interface ToppingService {
    List<Topping> getAllTopping();
    void saveTopping(ToppingDTO toppingDTO);
    void deleteTopping(Long id);
    Topping findToppingById(Long id);
}
