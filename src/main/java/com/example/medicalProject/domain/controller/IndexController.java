package com.example.medicalProject.domain.controller;

import com.example.medicalProject.config.auth.PrincipalDetails;
import com.example.medicalProject.domain.entity.patientInfo.PatientInfoService;
import com.example.medicalProject.domain.entity.user.Role;
import com.example.medicalProject.domain.entity.user.User;
import com.example.medicalProject.domain.entity.user.UserRepository;
import com.example.medicalProject.web.dto.UserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final UserRepository userRepository;
    private final PatientInfoService patientInfoService;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal PrincipalDetails userDetails, Model model) {
        if (userDetails != null) {
            Optional<User> user = userRepository.findById(userDetails.getId());
            if (user.isPresent()) {
                model.addAttribute("loginUser", user.get());
            }
        }
        return "index";
    } // 메인화면

    @GetMapping("/patientInfo")
    public @ResponseBody
    String patientInfo(Model model) {
//        model.addAttribute(patientInfoService.getPatientInfos())
        return "patientInfo";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    } // 로그인 화면

    @GetMapping("/registrationForm")
    public String registrationForm() {
        return "registrationForm";
    } // 회원가입 화면

    @Secured(Role.ROLES.DOCTOR)
    @GetMapping("/info")
    public @ResponseBody
    String info() {
        return "개인정보";
    }
}
