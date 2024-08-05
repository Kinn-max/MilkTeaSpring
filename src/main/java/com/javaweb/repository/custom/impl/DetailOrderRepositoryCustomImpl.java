package com.javaweb.repository.custom.impl;

import com.javaweb.constants.SystemConstant;
import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.entity.DetailOrder;
import com.javaweb.entity.Order;
import com.javaweb.repository.custom.DetailOrderRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DetailOrderRepositoryCustomImpl implements DetailOrderRepositoryCustom {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<DetailOrder> listDetailOrderActive() {
        String sql = "SELECT * FROM `detail_order` WHERE status = ?;";
        Query query = entityManager.createNativeQuery(sql, DetailOrder.class);
        query.setParameter(1, SystemConstant.WAIT_FOR_CONFIRM);
        return query.getResultList();
    }
}
