package com.javaweb.controllers.admin;


import com.javaweb.api.admin.CategoryAPI;
import com.javaweb.dto.CategoryDTO;
import com.javaweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "categoryOfAdmin")
public class CategoryAdminController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/admin/category-list", method = RequestMethod.GET)
    public ModelAndView adminCategoryList() {
        ModelAndView mav = new ModelAndView("admin/category-list");
        List<CategoryDTO> categoryList = categoryService.findAllCategory();
        mav.addObject("categoryList", categoryList);
        return mav;
    }
}
