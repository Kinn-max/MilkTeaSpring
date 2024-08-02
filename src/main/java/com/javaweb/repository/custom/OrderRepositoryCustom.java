package com.javaweb.repository.custom;

import com.javaweb.dto.OrderDTO;
import com.javaweb.entity.Order;

import java.util.List;

public interface OrderRepositoryCustom {
    List<Order> getAllOrderByUserId(Long userId,Boolean status);
}
