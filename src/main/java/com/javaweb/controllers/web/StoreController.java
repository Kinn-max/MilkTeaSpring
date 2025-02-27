package com.javaweb.controllers.web;

import com.javaweb.Security.utils.SecurityUtils;
import com.javaweb.dto.CategoryDTO;
import com.javaweb.dto.OrderResponseDTO;
import com.javaweb.dto.ProductDTO;
import com.javaweb.dto.ToppingDTO;
import com.javaweb.entity.Category;
import com.javaweb.entity.Product;
import com.javaweb.entity.Topping;
import com.javaweb.enums.Sugar;
import com.javaweb.service.CategoryService;
import com.javaweb.service.OrderService;
import com.javaweb.service.ProductService;
import com.javaweb.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "storeControllerOfWeb")
public class StoreController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ToppingService toppingService;
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/store", method = RequestMethod.GET)
    public ModelAndView storePage() {
        ModelAndView mav = new ModelAndView("web/list");
        List<CategoryDTO> categoryDTOList = categoryService.findAllCategory();
        mav.addObject("categoryDTOList", categoryDTOList);
        List<ProductDTO> productDTOList = productService.findAllProduct();
        List<ToppingDTO> toppingList = toppingService.getAllTopping();
        List<OrderResponseDTO> orderList = orderService.getAllOrders(SecurityUtils.getMyUser().getId());
        mav.addObject("orderList",orderList);
        mav.addObject("toppingList", toppingList);
        mav.addObject("sugarList", Sugar.type());
        mav.addObject("productDTOList", productDTOList);
        mav.addObject("productDTOList", productDTOList);
        return mav;
    }
}
