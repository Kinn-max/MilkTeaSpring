package com.javaweb.repository.custom;

import com.javaweb.entity.User;

public interface UserRepositoryCustom {
    User findNameUserAndActive(String nameUser);
}
