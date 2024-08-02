package com.javaweb.repository;

import com.javaweb.entity.User;
import com.javaweb.repository.custom.CategoryRepositoryCustom;
import com.javaweb.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> , UserRepositoryCustom {
    boolean existsByNameUser(String nameUser);
    boolean existsByEmail(String email);//check user name
    Optional<User> findByNameUser(String nameUser);
}
