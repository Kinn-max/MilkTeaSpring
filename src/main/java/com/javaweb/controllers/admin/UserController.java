package com.javaweb.controllers.admin;

import com.javaweb.api.admin.UserAPI;
import com.javaweb.dto.UserRequireDTO;
import com.javaweb.dto.UserResponseDTO;
import com.javaweb.entity.User;
import com.javaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("userOfAdmin")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserAPI userAPI;
    @RequestMapping(value = "/admin/user-list", method = RequestMethod.GET)
    public ModelAndView userAdmin(@ModelAttribute UserResponseDTO userResponseDTO){
        ModelAndView mav = new ModelAndView("admin/user-list");
        List<UserResponseDTO> listUser = userService.getAllUser();
        mav.addObject("userResponse", userResponseDTO);
        mav.addObject("listUser", listUser);
        return mav;
    }
    @RequestMapping(value = "/admin/user-edit-{id}", method = RequestMethod.GET)
    public ModelAndView userAdminEdit(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("admin/user-list");
        List<UserResponseDTO> listUser = userService.getAllUser();
        UserResponseDTO userResponseDTO = userAPI.findUserById(id);
        mav.addObject("userResponse", userResponseDTO);
        mav.addObject("listUser", listUser);
        return mav;
    }
}
