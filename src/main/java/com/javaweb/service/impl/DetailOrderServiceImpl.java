package com.javaweb.service.impl;

import com.javaweb.Security.utils.SecurityUtils;
import com.javaweb.constants.SystemConstant;
import com.javaweb.converter.DetailOrderConverter;
import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.entity.DetailOrder;
import com.javaweb.entity.Order;
import com.javaweb.repository.DetailOrderRepository;
import com.javaweb.repository.OrderRepository;
import com.javaweb.service.DetailOrderService;
import com.javaweb.service.EmailService;
import com.javaweb.util.FormEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DetailOrderServiceImpl implements DetailOrderService {
    @Autowired
    private DetailOrderRepository detailOrderRepository;

    @Autowired
    private DetailOrderConverter detailOrderConverter;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private FormEmail formEmail;

    @Override
    public void addDetailOrder(DetailOrderDTO detailOrderDTO) {
        DetailOrder detailOrder = detailOrderConverter.convertToDetailOrder(detailOrderDTO);
        detailOrderRepository.save(detailOrder);
        List<Order> listOrder = orderRepository.getAllOrderByUserId(SecurityUtils.getMyUser().getId(), false);
        for (Order order : listOrder) {
            order.setStatus(true);
            order.setDetailOrder(detailOrder);
            orderRepository.save(order);
        }
        detailOrderRepository.save(detailOrder);
        String detail = "";
        double total = 0.0;
        List<Order> orders = detailOrder.getOrderList();
        for (Order order : orders) {
            detail += "<p>- Sản phẩm: "+order.getProduct().getName()+"</p>\n";
            detail += "<p>- Số lượng:"+order.getQuantity()+"</p>\n";
            total += order.getTotalCurrent();
        }
        detail += "<p><strong><span style=\"color: #ff0000;\">Tổng giá:</span></strong>"+total+"</p>\n";
        formEmail.sendEmailDetailOrder("kinmax200418@gmail.com",detail);
    }

    @Override
    public List<DetailOrderDTO> getDetailOrderWait() {
        List<DetailOrder> detailOrderList = detailOrderRepository.listDetailOrderActive();
        List<DetailOrderDTO> detailOrderDTOList = new ArrayList<>();
        for (DetailOrder detailOrder : detailOrderList) {
            DetailOrderDTO detailOrderDTO =  detailOrderConverter.convertToDetailOrderDTO(detailOrder);
            detailOrderDTOList.add(detailOrderDTO);
        }
        return detailOrderDTOList;
    }

    @Override
    public DetailOrderDTO getDetailOrderDTOById(Long id) {
        DetailOrder  detailOrder = detailOrderRepository.findById(id).get();
        return detailOrderConverter.convertToDetailOrderDTO(detailOrder);
    }

    @Override
    public void setStatusDetailOrder(Long id, String status) {
        DetailOrder detailOrder = detailOrderRepository.findById(id).get();
        detailOrder.setStatus(status);
        detailOrderRepository.save(detailOrder);
    }

    @Override
    public List<DetailOrderDTO> getAllDetailOrder() {
        List<DetailOrder> detailOrderList = detailOrderRepository.findAll();
        List<DetailOrderDTO> detailOrderDTOList = new ArrayList<>();
        for (DetailOrder detailOrder : detailOrderList) {
            DetailOrderDTO detailOrderDTO =  detailOrderConverter.convertToDetailOrderDTO(detailOrder);
            detailOrderDTOList.add(detailOrderDTO);
        }
        return detailOrderDTOList;
    }

}
