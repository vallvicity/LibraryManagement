package com.example.LibraryManagement.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("homeMessage", "Welcome to the Library App!");
        return "home";
    }

    @RequestMapping("/home")
    public String getHome(Model model) {

        model.addAttribute("todayDate", new Date().toString());
        return "home";
    }


}
