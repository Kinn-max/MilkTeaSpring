package com.javaweb.controllers.admin;


import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.enums.OptionOrderActive;
import com.javaweb.service.DetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "orderOfAdmin")
public class OrderAdminController {
    @Autowired
    private DetailOrderService detailOrderService;
    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public ModelAndView orderAdmin() {
        ModelAndView modelAndView = new ModelAndView("admin/order-list");
        List<DetailOrderDTO> detailOrderDTOList = detailOrderService.getAllDetailOrder();
        modelAndView.addObject("detailOrderDTOList", detailOrderDTOList);
        modelAndView.addObject("statusDetailOrder", OptionOrderActive.type());
        return modelAndView;
    }
}
