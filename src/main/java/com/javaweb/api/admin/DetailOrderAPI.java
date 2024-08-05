package com.javaweb.api.admin;


import com.javaweb.constants.SystemConstant;
import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.entity.DetailOrder;
import com.javaweb.entity.Order;
import com.javaweb.entity.Topping;
import com.javaweb.repository.DetailOrderRepository;
import com.javaweb.repository.OrderRepository;
import com.javaweb.repository.ToppingRepository;
import com.javaweb.service.DetailOrderService;
import com.javaweb.util.FormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "detailOrderApiOfAdmin")
@Transactional
@RequestMapping("api/detail-order")
public class DetailOrderAPI {
    @Autowired
    private DetailOrderService detailOrderService;
    @Autowired
    private DetailOrderRepository detailOrderRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ToppingRepository toppingRepository;

    @GetMapping(value = "/{id}")
    public DetailOrderDTO getProductById(@PathVariable("id") Long id) {
        DetailOrderDTO detailOrderDTO=  detailOrderService.getDetailOrderDTOById(id);
        return detailOrderDTO;
    }
    @PostMapping(value = "/{id}")
    public ResponseEntity<String>  activeStatus(@PathVariable("id") Long id) {
        try {
            detailOrderService.setStatusDetailOrder(id, SystemConstant.DELIVERING);
            return FormResponse.contentOk("success","Cập nhật đơn hàng thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("success","Lỗi cập nhật");
        }
    }
    @PostMapping(value = "/{id}/{status}")
    public ResponseEntity<String>  activeStatusOption(@PathVariable("id") Long id, @PathVariable("status") String status) {
        try {
            detailOrderService.setStatusDetailOrder(id,status);
            return FormResponse.contentOk("success","Cập nhật đơn hàng thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("success","Lỗi cập nhật");
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String>  activeStatusOption(@PathVariable("id") Long id){
        try {

            DetailOrder detailOrder = detailOrderRepository.findById(id).get();
            List<Order> orderList = detailOrder.getOrderList();
            for (Order order : orderList) {
                order.getToppingList().clear();
                orderRepository.delete(order);
            }
            detailOrderRepository.deleteById(id);
            return FormResponse.contentOk("success","Cập nhật đơn hàng thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("success","Lỗi cập nhật");
        }
    }


}
