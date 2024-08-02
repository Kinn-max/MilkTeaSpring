package com.javaweb.repository.custom.impl;

import com.javaweb.entity.User;
import com.javaweb.repository.custom.UserRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findNameUserAndActive(String nameUser) {
        String sql = "SELECT * FROM user WHERE name_user = \"" + nameUser + "\" AND is_active = true;";
        Query query = entityManager.createNativeQuery(sql.toString(), User.class);
        return (User) query.getSingleResult();
    }


}
