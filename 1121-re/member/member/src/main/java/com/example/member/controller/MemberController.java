package com.example.member.controller;

import com.example.member.dto.MemberDto;
import com.example.member.mappers.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberMapper memberMapper;

    @GetMapping("")
    public String getList() {

        return "member/list.html";
    }

    @PostMapping("")
    @ResponseBody
    public Map<String, Object> getList(@RequestParam(defaultValue = "") String searchType, @RequestParam(defaultValue = "") String words) {
        Map<String, Object> map = new HashMap<>();
        String queryString = "";
        if (searchType.equals("email")) {
            System.out.println("email");
            queryString = "where email = '"+words+"'";
            map.put("msg", "ok");
            map.put("member" ,memberMapper.getMemberList(queryString));

        }else if (searchType.equals("name")) {
            queryString = "where name = '"+words+"'";
            map.put("msg", "ok");
            map.put("member" ,memberMapper.getMemberList(queryString));

        }else {
            queryString = "";
            map.put("msg", "ok");
            map.put("member" ,memberMapper.getMemberList(queryString));
        }



        return map;
    }

    @GetMapping("/insert")
    public String getInsert() {
        return "member/insert.html";
    }

    @PostMapping("/insert")
    @ResponseBody
    public Map<String, Object> setInsert(@ModelAttribute MemberDto memberDto) {

        Map<String, Object> map = new HashMap<>();
        if (memberDto != null) {
            memberMapper.setInsert(memberDto);
            map.put("msg", "ok");
        }

        return map;
    }

    @GetMapping("/delete")
    public String deleteMember(@RequestParam int id, RedirectAttributes ra) {
        memberMapper.deleteMember(id);
        ra.addFlashAttribute("msg", "삭제되었습니다.");
        return "redirect:/member";
    }

//    @GetMapping("/view")
//    public String viewMember(@RequestParam int id) {
//
//        memberMapper.viewMember(id);
//        return "member/view.html";
//    }
}
