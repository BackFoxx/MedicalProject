package com.example.medicalProject.web.dto;

import com.example.medicalProject.domain.entity.patientInfo.PatientInfo;
import com.example.medicalProject.domain.entity.user.Role;
import com.example.medicalProject.domain.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserInterceptorResponseDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Role role;

    @Builder
    public UserInterceptorResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
    }
}
