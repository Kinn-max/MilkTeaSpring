package com.javaweb.service.impl;

import com.javaweb.dto.ToppingDTO;
import com.javaweb.entity.Topping;
import com.javaweb.repository.ToppingRepository;
import com.javaweb.service.ToppingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ToppingServiceImpl implements ToppingService {
    @Autowired
    private ToppingRepository toppingRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<Topping> getAllTopping() {
        List<Topping> toppings = toppingRepository.findAll();
        return toppings;
    }

    @Override
    public void saveTopping(ToppingDTO toppingDTO) {
        Topping topping = modelMapper.map(toppingDTO, Topping.class);
        if(!topping.getName().equals("") &&  topping.getPrice() != 0  ){
            toppingRepository.save(topping);
        }
    }

    @Override
    public void deleteTopping(Long id) {
        toppingRepository.deleteById(id);
    }

    @Override
    public Topping findToppingById(Long id) {
        return toppingRepository.findById(id).get();
    }
}
