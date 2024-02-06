package com.hyun.CRUD.domain.member.controller;

import com.hyun.CRUD.domain.member.dto.MemberResponseDTO;
import com.hyun.CRUD.domain.member.dto.MemberSaveRequestDTO;
import com.hyun.CRUD.domain.member.service.MemberAuthService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberAuthController {

    private final MemberAuthService memberAuthService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("memberSaveRequestDTO", new MemberSaveRequestDTO());
        return "signup"; // signup.html로 이동
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberSaveRequestDTO requestDTO) {
        memberAuthService.join(requestDTO);
        return "redirect:/login"; // 로그인 페이지로 리다이렉트
    }

    // 로그인 폼 보여주기
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("memberLoginDTO", new MemberResponseDTO());
        return "login"; // login.html로 이동
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(@ModelAttribute MemberResponseDTO loginDTO, Model model, HttpSession session) {
        String name = loginDTO.getName();
        String password = loginDTO.getPassword();
        boolean loginResult = memberAuthService.login(name, password);
        if (loginResult) {
            session.setAttribute("name", name); // 세션에 사용자 이름 저장
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // 로그인 실패 시 로그인 페이지로 다시 이동
        }
    }
}
