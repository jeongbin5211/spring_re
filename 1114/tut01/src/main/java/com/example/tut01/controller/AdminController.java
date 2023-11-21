package com.example.tut01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/admin")
    public String getHome() {
        return "admin/admin.html";
    }

    @GetMapping("/employees")
    public String getEmployees() {
        return "admin/employees";
    }

    @GetMapping("/article")
    public String getArticle() {
        return "admin/article";
    }

    @GetMapping("/site")
    public String getSite() {
        return "admin/site";
    }
}
