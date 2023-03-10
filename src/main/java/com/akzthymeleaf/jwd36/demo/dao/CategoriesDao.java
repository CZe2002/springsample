package com.akzthymeleaf.jwd36.demo.dao;

import com.akzthymeleaf.jwd36.demo.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CategoriesDao extends JpaRepository<Categories, Integer> {

}
