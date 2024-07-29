package com.javaweb.repository;

import com.javaweb.entity.Category;
import com.javaweb.repository.custom.CategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long>, CategoryRepositoryCustom {

}
