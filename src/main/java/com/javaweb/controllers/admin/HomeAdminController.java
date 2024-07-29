package com.javaweb.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
public class HomeAdminController {

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView homePageAdmin() {
        ModelAndView mav = new ModelAndView("admin/home");
        return mav;
    }
}
