package com.javaweb.repository;

import com.javaweb.entity.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailOrderRepository extends JpaRepository<DetailOrder, Long> {
}
