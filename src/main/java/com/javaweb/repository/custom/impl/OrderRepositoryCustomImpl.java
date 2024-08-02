package com.javaweb.repository.custom.impl;

import com.javaweb.dto.OrderDTO;
import com.javaweb.entity.Order;
import com.javaweb.entity.User;
import com.javaweb.repository.custom.OrderRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Order> getAllOrderByUserId(Long userId,Boolean satus) {
        String sql = "SELECT * FROM `order` WHERE id_user = ? AND status = ?";
        Query query = entityManager.createNativeQuery(sql, Order.class);
        query.setParameter(1, userId);
        query.setParameter(2, satus);
        return query.getResultList();
    }


}
