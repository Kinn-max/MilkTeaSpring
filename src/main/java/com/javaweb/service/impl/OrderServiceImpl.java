package com.javaweb.service.impl;

import com.javaweb.converter.OrderConverter;
import com.javaweb.dto.OrderDTO;
import com.javaweb.dto.OrderResponseDTO;
import com.javaweb.entity.Order;
import com.javaweb.entity.Topping;
import com.javaweb.repository.OrderRepository;
import com.javaweb.repository.ToppingRepository;
import com.javaweb.service.OrderService;
import com.javaweb.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderConverter orderConverter;
    @Autowired
    private ToppingRepository toppingRepository;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        Order order = orderConverter.toOrder(orderDTO);
        order = orderRepository.save(order);
        List<Long> toppingList = orderDTO.getToppingList();
        for (Long id : toppingList) {
            Topping topping = toppingRepository.findById(id).orElseThrow(() -> new RuntimeException("Topping not found"));
            order.getToppingList().add(topping);
            topping.getOrderList().add(order);
        }
        orderRepository.save(order);
    }

    @Override
    public List<OrderResponseDTO> getAllOrders(Long id) {
        List<Order> myOrderList = orderRepository.getAllOrderByUserId(id,false);
        List<OrderResponseDTO> orderDTOList = new ArrayList<>();
        for (Order order : myOrderList) {
           orderDTOList.add(orderConverter.toOrderResponseDTO(order));
        }
        return orderDTOList;
    }
}
