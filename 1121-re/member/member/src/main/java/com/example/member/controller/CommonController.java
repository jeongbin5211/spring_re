package com.example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/common/main")
    public String getMain() {
        return "common/main.html";
    }
}
