package com.example.medicalProject.domain.controller;

import com.example.medicalProject.config.auth.PrincipalDetails;
import com.example.medicalProject.domain.entity.patientInfo.PatientInfoService;
import com.example.medicalProject.domain.entity.user.Role;
import com.example.medicalProject.domain.entity.user.User;
import com.example.medicalProject.domain.entity.user.UserRepository;
import com.example.medicalProject.web.dto.PatientInfoListResponseDto;
import com.example.medicalProject.web.dto.UserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final UserRepository userRepository;
    private final PatientInfoService patientInfoService;

    @GetMapping("/")
    public String index() {
        return "index";
    } // 메인화면

    @GetMapping("/loginForm")
    public String loginForm(Model model, @AuthenticationPrincipal PrincipalDetails user) {
        if (user != null) {
            model.addAttribute("error", "이미 로그인되어 있지 않습니까!");
        }
        return "loginForm";
    } // 로그인 화면

    @GetMapping("/registrationForm")
    public String registrationForm(Model model, @AuthenticationPrincipal PrincipalDetails user) {
        if (user != null) {
            model.addAttribute("error", "이미 로그인되어 있지 않습니까!");
        }
        return "registrationForm";
    } // 회원가입 화면
}
