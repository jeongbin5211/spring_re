package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AjaxController2 {

    @GetMapping("/test")
    @ResponseBody
    @CrossOrigin
    public String getTest() {
      return "테스트 성공!";
    };

    @PostMapping("/getData")
    @ResponseBody
    @CrossOrigin("*")
    public Map<String, Object> setData() {
        // email, passwd, name, age
        // Map<key, value>
        Map<String, Object> map = new HashMap<>();
        map.put("email", "email@email.com");
        map.put("passwd", "1234");
        map.put("name", "홍길동");
        map.put("age", 10);

        return map;
    };

    @GetMapping("/setData")
    @ResponseBody
    @CrossOrigin("*")
    public Map<String, Object> setData(String code, String name) {
        System.out.println(code);
        System.out.println(name);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", "success");
        return map;
    };
}
