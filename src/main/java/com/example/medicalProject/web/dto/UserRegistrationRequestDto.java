package com.example.medicalProject.web.dto;

import com.example.medicalProject.domain.entity.user.Role;
import com.example.medicalProject.domain.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRegistrationRequestDto {
    @NotBlank(message = "유저네임은 필수 입력값입니다.")
    private String username;
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
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
