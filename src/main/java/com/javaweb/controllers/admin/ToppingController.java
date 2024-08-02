package com.javaweb.controllers.admin;

import com.javaweb.api.admin.ToppingAPI;
import com.javaweb.dto.ProductDTO;
import com.javaweb.dto.ToppingDTO;
import com.javaweb.entity.Topping;
import com.javaweb.repository.ToppingRepository;
import com.javaweb.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("toppingOfAdmin")
public class ToppingController {
    @Autowired
    private ToppingService toppingService;
    @RequestMapping(value = "/admin/topping-list", method = RequestMethod.GET)
    public ModelAndView toppingList(@ModelAttribute ToppingDTO toppingDTO) {
        ModelAndView mav = new ModelAndView("admin/topping-list");
        List<ToppingDTO> toppingList = toppingService.getAllTopping();
        mav.addObject("toppingList", toppingList);
        mav.addObject("toppingDTO", toppingDTO);
        return mav;
    }
}
