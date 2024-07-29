package com.javaweb.service.impl;

import com.javaweb.config.AppConfig;
import com.javaweb.converter.ProductConverter;
import com.javaweb.dto.ProductDTO;
import com.javaweb.entity.Category;
import com.javaweb.entity.Product;
import com.javaweb.repository.ProductRepository;
import com.javaweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private AppConfig appConfig;
    @Override
    public List<ProductDTO> findAllProduct() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            ProductDTO productDTO =  productConverter.toProductDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public void saveProduct(ProductDTO productDTO, MultipartFile file) {
        String fileName = StringUtils.cleanPath( file.getOriginalFilename());
        productDTO.setImage(fileName);
        String dir = appConfig.getImgDir();
        Product  product = new Product();
        if(productDTO.getId() != null){
            product = productRepository.findById(productDTO.getId()).get();
        }
        product = productConverter.toProduct(productDTO);
        if (product.getCategory() != null  && !fileName.isEmpty()) {
            try {
                Path path = Paths.get(dir + File.separator + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            productRepository.save(product);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        deleteProductImage(product.getImage());
        productRepository.deleteById(id);
    }

    @Override
    public ProductDTO findProductById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDTO productDTO =  productConverter.toProductDTOForm(product);
        return productDTO;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProductImage(String fileName) {
        String dir = appConfig.getImgDir();
        Path path = Paths.get(dir + File.separator + fileName);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
