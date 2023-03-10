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
import java.util.Optional;


@Controller
@RequestMapping(value = "/category")
public class CategoriesController {

    @Autowired
    private CategoriesDao categoriesDao;

    @GetMapping(value = "/create")
    public String createCategoriesGet(Model model) {
        List<Categories> categories = categoriesDao.findAll();
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(categories.get(i).getCatName());

        }
        model.addAttribute("title", "Category Create");
        System.out.println("Get");
        return "category/create";
    }

    @PostMapping(value = "/create")
    public String createCategoriesPost(Model model, @RequestParam String category) {
        model.addAttribute("title", "Category Create");
        System.out.println("Post");
        Categories categories = new Categories();
        categories.setCatName(category);
        categoriesDao.save(categories);
        return "category/create";
    }

    @GetMapping(value = "/view")
    public String viewALlGet(Model model) {
        List<Categories> categories = categoriesDao.findAll();
        model.addAttribute("categories",categories);
        return "category/viewAll";
        }


    @GetMapping(value="/show")
    public String show(@RequestParam("id") Integer id, Model model){
        Optional<Categories> categories= categoriesDao.findById(id);
        model.addAttribute("categories",categories);
        return "category/show";
    }
}
