package com.javaweb.api.admin;

import com.javaweb.dto.CategoryDTO;
import com.javaweb.dto.ProductDTO;
import com.javaweb.entity.Product;
import com.javaweb.service.CategoryService;
import com.javaweb.service.ProductService;
import com.javaweb.util.FormResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController(value = "productApiOfAdmin")
@Transactional
@RequestMapping("api/product")
public class ProductAPI {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "")
    public ResponseEntity<String> saveProduct(@ModelAttribute ProductDTO productDTO, @RequestParam("file-product") MultipartFile file) {
        try {
            productService.saveProduct(productDTO, file);
            return FormResponse.contentOk("success","Thêm sản phẩm thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("success","Lỗi sản phẩm");
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        try {
            productService.deleteProduct(id);
            return FormResponse.contentOk("success","Xóa sản phẩm thành công");
        } catch (Exception e) {
            return FormResponse.contentNotOk("error","Lỗi khi xóa sản phẩm");
        }
    }
    @GetMapping(value = "/{id}")
    public ProductDTO getProductById(@PathVariable("id") Long id) {
          ProductDTO productDTO=  productService.findProductById(id);
          return productDTO;
    }

}
