package com.example.tut04.controller;

import com.example.tut04.dto.RegDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RegController {

    @GetMapping("/users/register")
    public String getReg() {
        return "/users/register.html";
    }

    @PostMapping("/users/register")
    @ResponseBody
    public Map<String, Object> setReg(@ModelAttribute RegDto regDto) {
        System.out.println(regDto);
        System.out.println(regDto.toString());

        Map<String, Object> map = new HashMap<>();
        map.put("status", "200");
        map.put("msg", "성공");

        return map;
    }
}
