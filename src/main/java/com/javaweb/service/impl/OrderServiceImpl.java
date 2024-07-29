package com.javaweb.service.impl;

import com.javaweb.converter.OrderConverter;
import com.javaweb.dto.OrderDTO;
import com.javaweb.entity.Order;
import com.javaweb.repository.OrderRepository;
import com.javaweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderConverter orderConverter;
    @Override
    public void saveOrder(OrderDTO orderDTO) {
        Order order = orderConverter.toOrder(orderDTO);
        orderRepository.save(order);
    }
}
