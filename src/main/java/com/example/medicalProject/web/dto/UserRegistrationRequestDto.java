package com.example.medicalProject.web.dto;

import com.example.medicalProject.domain.entity.user.Role;
import com.example.medicalProject.domain.entity.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDto {
    private String username;
    private String email;
    private String password;
    private Role role;

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .role(this.role)
                .build();
    }
}
