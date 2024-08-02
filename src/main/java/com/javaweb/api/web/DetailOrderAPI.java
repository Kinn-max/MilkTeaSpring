package com.javaweb.api.web;


import com.javaweb.Security.utils.SecurityUtils;
import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.dto.MyUserDetail;
import com.javaweb.dto.OrderDTO;
import com.javaweb.service.DetailOrderService;
import com.javaweb.util.FormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "buyNowApiOfWeb")
@Transactional
@RequestMapping("api/buy-now")
public class DetailOrderAPI {
    @Autowired
    private DetailOrderService detailOrderService;
    @PostMapping(name = "")
    public ResponseEntity<String> saveDetailOrderSameBuyNow(@RequestBody DetailOrderDTO detailOrderDTO){
        MyUserDetail myUser = SecurityUtils.getMyUser();
        if (myUser != null) {
            detailOrderService.addDetailOrder(detailOrderDTO);
            return FormResponse.contentOk("message","Mua hàng thành công");
        }
        return FormResponse.contentOk("message","Đã xảy ra lỗi");
    }
}
