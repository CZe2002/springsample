package com.akzthymeleaf.jwd36.demo.controllers;

import com.akzthymeleaf.jwd36.demo.dao.CategoriesDao;
import com.akzthymeleaf.jwd36.demo.models.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/Category")
public class CategoriesController {

    @Autowired
    CategoriesDao categoriesDao;

    @GetMapping(value = "/create")
    public String createCategoriesGet(Model model){
        List<Categories> categories=categoriesDao.findAll();
        for(int i=0;i<categories.size();i++){
            System.out.println(categories.get(i).getCatName());

        }
        model.addAttribute("title","Category Create");
        System.out.println("Get");
        return "Category/create";
    }

    @PostMapping(value = "/create")
    public String createCategoriesPost(Model model, @RequestParam String category){
        model.addAttribute("title","Category Create");
        System.out.println("Post");
        Categories categories=new Categories();
        categories.setCatName(category);
        categoriesDao.save(categories);
        return "Category/create";
    }

}
