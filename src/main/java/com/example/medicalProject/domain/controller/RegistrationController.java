package com.example.medicalProject.domain.controller;

import com.example.medicalProject.domain.entity.user.Role;
import com.example.medicalProject.domain.entity.user.UserService;
import com.example.medicalProject.web.dto.UserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    public String registration(UserRegistrationRequestDto user) {
        user.setRole(Role.ROLE_DOCTOR);
        userService.registration(user);
        return "redirect:/loginForm";
    } // 실제 회원가입
}
