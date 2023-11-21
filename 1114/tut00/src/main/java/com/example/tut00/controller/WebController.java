package com.example.tut00.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    @GetMapping("")
    public String getHome(Model model) {
        model.addAttribute("title", "Welcome to my world");
        model.addAttribute("intro", "설명글");
        return "index.html";
    }

    @GetMapping("/company")
    public String getCompany(Model model) {
        model.addAttribute("title", "company");
        model.addAttribute("subTitle", "company");
        return "sub/company.html";
    }
}
