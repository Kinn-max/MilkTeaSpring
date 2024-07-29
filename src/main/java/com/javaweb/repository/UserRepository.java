package com.javaweb.repository;

import com.javaweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByNameUser(String nameUser);
    boolean existsByEmail(String email);//check user name
    Optional<User> findByNameUser(String phoneNumber);
}
