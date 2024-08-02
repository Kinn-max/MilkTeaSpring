package com.javaweb.repository;

import com.javaweb.entity.Order;
import com.javaweb.repository.custom.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>, OrderRepositoryCustom {

}
