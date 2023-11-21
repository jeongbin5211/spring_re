package com.example.tut02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/login")
    public String getLogin() {
        return "users/login.html";
    }

    @GetMapping("/register")
    public String getReg() {
        return "users/register.html";
    }

    @GetMapping("/getAjax")
    @ResponseBody
    public Map<String, Object> getAjax() {
        Map<String, Object> map = new HashMap<>();
        map.put("userid", "koreait");
        map.put("passwd", "12345");
        return map;
    }

    @PostMapping("/setAjax")
    @ResponseBody
    public Map<String, Object> setAjax(@RequestParam String userid, @RequestParam String passwd) {
        System.out.println(userid);
        System.out.println(passwd);

        Map<String, Object> map = new HashMap<>();

        if (userid != null) {
            map.put("msg", "데이터 전송 성공");
        }

        return map;

    }
}
