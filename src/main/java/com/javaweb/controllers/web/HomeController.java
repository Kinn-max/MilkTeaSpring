package com.javaweb.controllers.web;

import com.javaweb.Security.utils.SecurityUtils;
import com.javaweb.dto.*;
import com.javaweb.service.OrderService;
import com.javaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller(value = "homeControllerOfWeb")
public class HomeController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("web/home");
        List<OrderResponseDTO> orderList = orderService.getAllOrders(SecurityUtils.getMyUser().getId());
        mav.addObject("orderList", orderList);
        return mav;
    }
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public ModelAndView cartPage() {
        ModelAndView mav = new ModelAndView("web/cart");
        List<OrderResponseDTO> orderList = orderService.getAllOrders(SecurityUtils.getMyUser().getId());
        UserResponseDTO userResponseDTO = userService.getUserById(SecurityUtils.getMyUser().getId());
        mav.addObject("userResponseDTO", userResponseDTO);
        mav.addObject("orderList", orderList);
        return mav;
    }
    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerPage(@ModelAttribute UserRequireDTO userRequireDTO) {

        ModelAndView mav = new ModelAndView("register");
        mav.addObject("userRequireDTO", userRequireDTO);
        return mav;
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/home");
    }


}
