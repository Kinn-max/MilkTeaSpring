package com.javaweb.service;

import com.javaweb.dto.CategoryDTO;
import com.javaweb.entity.Category;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> findAllCategory();
    void saveCategory(String nameCategory, MultipartFile file);
    void deleteCategory(Long id);
    Category findCategoryById(Long id);
}
