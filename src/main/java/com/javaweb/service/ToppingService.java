package com.javaweb.service;

import com.javaweb.dto.ToppingDTO;
import com.javaweb.entity.Topping;

import java.util.List;

public interface ToppingService {
    List<ToppingDTO> getAllTopping();
    void saveTopping(ToppingDTO toppingDTO);
    void deleteTopping(Long id);
    ToppingDTO findToppingById(Long id);
}
