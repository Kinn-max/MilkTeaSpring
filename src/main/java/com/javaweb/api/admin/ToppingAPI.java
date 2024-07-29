package com.javaweb.api.admin;


import com.javaweb.dto.ProductDTO;
import com.javaweb.dto.ToppingDTO;
import com.javaweb.entity.Topping;
import com.javaweb.service.ToppingService;
import com.javaweb.util.FormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController(value = "toppingApiOfAdmin")
@Transactional
@RequestMapping("api/topping")
public class ToppingAPI {
    @Autowired
    private ToppingService toppingService;
    @PostMapping(value = "")
    public ResponseEntity<String> saveTopping(@RequestBody ToppingDTO toppingDTO) {
        try {
            toppingService.saveTopping(toppingDTO);
            return FormResponse.contentOk("success","Thêm topping thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("success","Lỗi topping");
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteTopping(@PathVariable Long id) {
        try {
            toppingService.deleteTopping(id);
            return FormResponse.contentOk("success","Xóa topping thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("success","Lỗi khi xóa topping");
        }
    }
}
