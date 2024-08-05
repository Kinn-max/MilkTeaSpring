package com.javaweb.service;

import com.javaweb.dto.DetailOrderDTO;
import java.util.List;

public interface DetailOrderService {
    void addDetailOrder(DetailOrderDTO detailOrderDTO);
    List<DetailOrderDTO> getDetailOrderWait();
    DetailOrderDTO getDetailOrderDTOById(Long id);
    void setStatusDetailOrder(Long id,String status);
    List<DetailOrderDTO> getAllDetailOrder();
}
