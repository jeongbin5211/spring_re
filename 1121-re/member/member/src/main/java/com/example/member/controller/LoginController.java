package com.example.member.controller;

import com.example.member.dto.MemberDto;
import com.example.member.mappers.MemberMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    MemberMapper memberMapper;

    @GetMapping("/login")
    public String getLogin() {
        return "login.html";
    }

    @PostMapping("/login")
    public String setLogin(@ModelAttribute MemberDto memberDto, RedirectAttributes ra, HttpServletRequest hsr) {

//        System.out.println(memberDto);
        MemberDto m = memberMapper.setLogin(memberDto);

        if (m != null) {
            // System.out.println("성공");
            // 세션 생성
            // getSession() -> 데이터 -> 시간
            HttpSession hs = hsr.getSession(); // 세션준비
            // 세션 만들 데이터
//            hs.setAttribute("uid", m.getUserid());
//            hs.setAttribute("uname", m.getUsername());

            hs.setAttribute("user", m);
            hs.setMaxInactiveInterval(10 * 60); // 10분

            ra.addFlashAttribute("msg", "000님 안녕하세요..");

            return "redirect:/member";
        }else {
            // System.out.println("실패");
            ra.addFlashAttribute("msg", "아이디/비밀번호를 확인하세요.");
            return "redirect:/login";
        }

    }

    @GetMapping("/logout")
    public String getLogout(HttpSession hs) {
        hs.invalidate();
        return "redirect:/login";
    }
}

