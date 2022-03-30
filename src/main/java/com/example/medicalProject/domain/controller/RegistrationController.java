package com.example.medicalProject.domain.controller;

import com.example.medicalProject.domain.entity.user.UserService;
import com.example.medicalProject.web.dto.UserRegistrationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    public String registration(@Valid UserRegistrationRequestDto user,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userForm", user);

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                model.addAttribute(fieldError.getField() + "ErrorMessage", fieldError.getDefaultMessage());
            }
            return "/registrationForm";
        }

        userService.registration(user);
        return "redirect:/loginForm";
    } // 실제 회원가입
}
