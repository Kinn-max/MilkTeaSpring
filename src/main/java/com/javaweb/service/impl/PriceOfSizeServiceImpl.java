package com.javaweb.service.impl;

import com.javaweb.entity.PriceOfSize;
import com.javaweb.repository.PriceOfSizeRepository;
import com.javaweb.service.PriceOfSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceOfSizeServiceImpl implements PriceOfSizeService {
    @Autowired
    private PriceOfSizeRepository priceOfSizeRepository;
    @Override
    public PriceOfSize getPriceOfSizeById(Long id) {
        PriceOfSize priceOfSize = priceOfSizeRepository.findById(id).get();
        return priceOfSize;
    }

    @Override
    public void savePriceOfSize(PriceOfSize priceOfSize) {
        priceOfSizeRepository.save(priceOfSize);

    }
}
