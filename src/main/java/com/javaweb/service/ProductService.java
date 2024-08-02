package com.javaweb.service;

import com.javaweb.dto.ProductDTO;
import com.javaweb.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProduct();
    void saveProduct(ProductDTO productDTO, MultipartFile file);
    void deleteProduct(Long id);
    ProductDTO findProductById(Long id);
}
