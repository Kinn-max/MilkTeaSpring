package com.javaweb.controllers.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "orderOfAdmin")
public class OrderAdminController {

    @RequestMapping(value = "/admin/order", method = RequestMethod.GET)
    public ModelAndView orderAdmin() {
        ModelAndView modelAndView = new ModelAndView("admin/order-list");
        return modelAndView;
    }
}
