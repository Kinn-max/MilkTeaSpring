package com.javaweb.api.admin;

import com.javaweb.dto.ToppingDTO;
import com.javaweb.dto.UserRequireDTO;
import com.javaweb.dto.UserResponseDTO;
import com.javaweb.entity.User;
import com.javaweb.service.UserService;
import com.javaweb.util.FormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController(value = "userApiOfAdmin")
@Transactional
@RequestMapping("api/user")
public class UserAPI {
    @Autowired
    private UserService userService;
    @PostMapping(value = "")
    public ResponseEntity<String> saveUser(@RequestBody UserResponseDTO userResponseDTO) {
        try {
            userService.saveUser(userResponseDTO);
            return FormResponse.contentOk("success","Thêm user thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("success","Lỗi user");
        }
    }

    @GetMapping(value = "/{id}")
    public UserResponseDTO findUserById(@PathVariable("id") Long id) {
        UserResponseDTO responseDTO = userService.getUserById(id);
        return responseDTO;
    }
    @PostMapping("/{id}/{status}")
    public  ResponseEntity<String>  saveActiveUser(@PathVariable("id") Long id,@PathVariable("status") Integer status){
        userService.saveActiveUser(id,status);
        return FormResponse.contentOk("success","Cập nhật trạng thái tài khoản thành công");
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String>  deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return FormResponse.contentOk("success","Xóa thành công User!");
    }


}
