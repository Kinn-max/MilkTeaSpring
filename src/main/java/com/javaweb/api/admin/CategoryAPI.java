package com.javaweb.api.admin;

import com.javaweb.dto.CategoryDTO;
import com.javaweb.entity.Category;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.service.CategoryService;
import com.javaweb.util.FormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController(value = "categoryApiOfAdmin")
@Transactional
@RequestMapping("api/category")
public class CategoryAPI {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping(value = "")
    public ResponseEntity<String> saveCategory(@RequestParam("name-category") String name, @RequestParam("file-category") MultipartFile file) {
        try {
            categoryService.saveCategory(name, file);
            return FormResponse.contentOk("success","Thêm danh mục thành công");
        } catch (Exception e) {
             return FormResponse.contentNotOk("success","Lỗi danh mục");
        }
    }
    @DeleteMapping(value = "")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        try {
            categoryService.deleteCategory(id);
            return FormResponse.contentOk("success","Xóa danh mục thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("error","Lỗi khi xóa danh mục");
        }
    }
}
