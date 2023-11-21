package com.example2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHome(Model model) {
        model.addAttribute("userid", "koreait");
        model.addAttribute("passwd", "1234");
        model.addAttribute("name", "홍길동");
      return "home/home";
    };
}
