package com.akzthymeleaf.jwd36.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("title","Home Page");
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title","About Page");
        return "about";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String loginGet(Model model){
        model.addAttribute("title","Login Page");
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginPost(Model model){
        model.addAttribute("title","Login Page");
        return "index";
    }

    @RequestMapping(value = "/category/search", method = RequestMethod.GET)
    public String search(Model model){
        model.addAttribute("title","Search Page");
        return "category/search";
    }
}
