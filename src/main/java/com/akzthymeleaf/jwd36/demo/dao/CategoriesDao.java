package com.akzthymeleaf.jwd36.demo.dao;

import com.akzthymeleaf.jwd36.demo.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesDao extends JpaRepository<Categories, Integer> {

}
