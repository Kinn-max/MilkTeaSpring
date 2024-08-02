package com.javaweb.service.impl;

import com.javaweb.config.AppConfig;
import com.javaweb.dto.CategoryDTO;
import com.javaweb.entity.Category;
import com.javaweb.repository.CategoryRepository;
import com.javaweb.service.CategoryService;
import org.modelmapper.ModelMapper;
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
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private AppConfig appConfig;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> findAllCategory() {
        List<Category> categoryList = categoryRepository.findAllCategory();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }

    @Override
    public void saveCategory(String nameCategory, MultipartFile file) {
        String fileName = StringUtils.cleanPath( file.getOriginalFilename());
        String dir = appConfig.getImgDir();

        Category category = new Category();
        category.setName(nameCategory);
        category.setImage(fileName);

        if (nameCategory != null && !fileName.isEmpty()) {
            try {
                Path path = Paths.get(dir + File.separator + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            categoryRepository.save(category);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).get();
        deleteCategoryImage(category.getImage());
        categoryRepository.delete(category);
    }

    public void deleteCategoryImage(String fileName) {
        String dir = appConfig.getImgDir();
        Path path = Paths.get(dir + File.separator + fileName);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
