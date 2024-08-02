package com.javaweb.converter;

import com.javaweb.dto.ToppingDTO;
import com.javaweb.entity.Topping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToppingCoverter {
    @Autowired
    private ModelMapper modelMapper;

    public ToppingDTO covertToDTO(Topping topping) {
        ToppingDTO toppingDTO = modelMapper.map(topping, ToppingDTO.class);
        return toppingDTO;
    }
}
