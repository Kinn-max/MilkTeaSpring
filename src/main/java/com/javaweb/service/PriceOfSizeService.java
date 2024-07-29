package com.javaweb.service;

import com.javaweb.entity.PriceOfSize;

public interface PriceOfSizeService {
    PriceOfSize getPriceOfSizeById(Long id);
    void savePriceOfSize(PriceOfSize priceOfSize);
}
