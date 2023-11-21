package com.example.tut05.controller;

import com.example.tut05.dto.UsersDto;
import com.example.tut05.mappers.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    @Autowired
    UsersMapper usersMapper;

    @GetMapping("/users/insert")
    public String getInsert() {
        return "users/insert.html";
    }

    @PostMapping("/users/insert")
    public String setInsert(@ModelAttribute UsersDto usersDto) {
        usersMapper.setInsert(usersDto);
        return "redirect: /users/insert";
    }

    @GetMapping("/users/list")
    public String getList() {
        return "users/list.html";
    }
}
