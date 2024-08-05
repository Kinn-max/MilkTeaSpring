package com.javaweb.repository;

import com.javaweb.entity.DetailOrder;
import com.javaweb.repository.custom.DetailOrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailOrderRepository extends JpaRepository<DetailOrder, Long>, DetailOrderRepositoryCustom {
}
