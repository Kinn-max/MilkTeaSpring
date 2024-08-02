package com.javaweb.api.web;

import com.javaweb.Security.utils.SecurityUtils;
import com.javaweb.dto.MyUserDetail;
import com.javaweb.dto.OrderDTO;
import com.javaweb.service.OrderService;
import com.javaweb.util.FormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController(value = "addCartApiOfWeb")
@Transactional
@RequestMapping("api/add-cart")
public class OrderAPI {
    @Autowired
    private OrderService orderService;
    @PostMapping("")
    public ResponseEntity<String> saveOrderSameAddCart(@RequestBody OrderDTO orderDTO){
        MyUserDetail myUser = SecurityUtils.getMyUser();
        if (myUser != null) {
            orderService.saveOrder(orderDTO);
            return FormResponse.contentOk("message","Thêm giỏ thành công");
        }
        return FormResponse.contentOk("message","Bạn chưa đăng nhập");
    }
}
