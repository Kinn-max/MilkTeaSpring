package com.javaweb.controllers.admin;

import com.javaweb.dto.DetailOrderDTO;
import com.javaweb.service.DetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "homeControllerOfAdmin")
public class HomeAdminController {
    @Autowired
    private DetailOrderService detailOrderService;;
    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView homePageAdmin() {
        ModelAndView mav = new ModelAndView("admin/home");
        List<DetailOrderDTO> orderDTOList = detailOrderService.getDetailOrderWait();
        mav.addObject("orderDTOList", orderDTOList);
        return mav;
    }
}
