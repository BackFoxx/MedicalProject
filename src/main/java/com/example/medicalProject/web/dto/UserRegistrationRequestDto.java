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
    private String roleName;

    public User toEntity() {
        Role role;
        switch (roleName) {
            case "doctor":
                role = Role.ROLE_DOCTOR;
                break;
            case "admin":
                role = Role.ROLE_ADMIN;
                break;
            default:
                role = Role.ROLE_USER;
        }

        return User.builder()
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .role(role)
                .build();
    }
}
