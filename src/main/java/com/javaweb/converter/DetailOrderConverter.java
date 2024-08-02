package com.javaweb.converter;

import com.javaweb.Security.utils.SecurityUtils;
import com.javaweb.constants.SystemConstant;
import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.dto.OrderResponseDTO;
import com.javaweb.entity.DetailOrder;
import com.javaweb.entity.Order;
import com.javaweb.entity.User;
import com.javaweb.repository.OrderRepository;
import com.javaweb.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DetailOrderConverter {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    public DetailOrder convertToDetailOrder(DetailOrderDTO detailOrderDTO) {
        Date dateTime = new Date();
        DetailOrder detailOrder = modelMapper.map(detailOrderDTO, DetailOrder.class);
        List<Order> listOrder = orderRepository.getAllOrderByUserId(SecurityUtils.getMyUser().getId(),false);
        detailOrder.setOrderList(listOrder);
        detailOrder.setCreatedDate(dateTime);
        detailOrder.setCreatedBy(SecurityUtils.getMyUser().getFullName());
        detailOrder.setStatus(SystemConstant.WAIT_FOR_CONFIRM);
        User user = userRepository.findById(SecurityUtils.getMyUser().getId()).get();
        detailOrder.setUser(user);
        return detailOrder;
    }
}
