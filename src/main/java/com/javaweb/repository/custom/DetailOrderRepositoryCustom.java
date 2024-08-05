package com.javaweb.repository.custom;

import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.entity.DetailOrder;

import java.util.List;

public interface DetailOrderRepositoryCustom {
    List<DetailOrder> listDetailOrderActive();
}
