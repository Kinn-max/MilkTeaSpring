package com.javaweb.repository.custom.impl;

import com.javaweb.dto.CategoryDTO;
import com.javaweb.entity.Category;
import com.javaweb.repository.custom.CategoryRepositoryCustom;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Category> findAllCategory() {
        String sql = "SELECT * FROM category ; ";
        Query query = entityManager.createNativeQuery(sql.toString(), Category.class);
        return query.getResultList();
    }
}
