package com.example.medicalProject.domain.entity.user;

import com.example.medicalProject.web.dto.UserRegistrationRequestDto;

public interface UserService {
    void registration(UserRegistrationRequestDto user); //회원가입
}
