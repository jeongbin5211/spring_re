package com.example.tut02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String getHome() {
        return "admin/index.html";
    }

    @GetMapping("/admin/article")
    public String getArticle() {
        return "admin/article.html";
    }

    @GetMapping("/admin/employees")
    public String getEmployees() {
        return "admin/employees.html";
    }
}
