package com.example.tut03.controller;

import com.example.tut03.dto.RegDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegController {

    @GetMapping("/users/register")
    public String getReg() {
        return "users/register";
    }

//    @PostMapping("/users/register")
//    public void setReg(@ModelAttribute RegDto regDto) {
//        System.out.println(regDto);
//    }

    @PostMapping("/users/register")
    public void setReg(@RequestParam String email, @RequestParam String passwd) {

        System.out.println(email + " " + passwd);
    }
}
