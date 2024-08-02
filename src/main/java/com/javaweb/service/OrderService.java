package com.javaweb.service;

import com.javaweb.dto.OrderDTO;
import com.javaweb.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderResponseDTO> getAllOrders(Long id);
}
