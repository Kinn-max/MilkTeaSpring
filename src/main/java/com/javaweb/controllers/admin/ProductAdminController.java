package com.javaweb.controllers.admin;

import com.javaweb.api.admin.CategoryAPI;
import com.javaweb.api.admin.ProductAPI;
import com.javaweb.dto.CategoryDTO;
import com.javaweb.dto.ProductDTO;
import com.javaweb.service.CategoryService;
import com.javaweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "productOfAdmin")
public class ProductAdminController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/admin/product-list", method = RequestMethod.GET)
    public ModelAndView adminProductList(ProductDTO productDTO) {
        ModelAndView mav = new ModelAndView("admin/product-list");
        List<ProductDTO> productList = productService.findAllProduct();
        List<CategoryDTO> categoryDTOList = categoryService.findAllCategory();
        mav.addObject("productList", productList);
        mav.addObject("categoryList", categoryDTOList);
        mav.addObject("productDTO", productDTO);
        return mav;
    }
    @RequestMapping(value = "/admin/product-list-{id}", method = RequestMethod.GET)
    public ModelAndView adminProductEdit(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/product-list");
        ProductDTO productDTO = productService.findProductById(id);
        List<ProductDTO> productList = productService.findAllProduct();
        List<CategoryDTO> categoryDTOList = categoryService.findAllCategory();
        mav.addObject("productList", productList);
        mav.addObject("categoryList", categoryDTOList);
        mav.addObject("productDTO", productDTO);
        return mav;
    }
}
