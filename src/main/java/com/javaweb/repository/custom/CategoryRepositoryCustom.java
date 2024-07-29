package com.javaweb.repository.custom;

import com.javaweb.dto.CategoryDTO;
import com.javaweb.entity.Category;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<Category> findAllCategory();
}
