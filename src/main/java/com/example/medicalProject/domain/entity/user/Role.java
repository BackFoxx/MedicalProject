package com.example.medicalProject.domain.entity.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    ROLE_USER(ROLES.USER, "일반 회원"),
    ROLE_DOCTOR(ROLES.DOCTOR, "의사"),
    ROLE_ADMIN(ROLES.ADMIN, "관리자");

    public static class ROLES {
        public static final String USER = "ROLE_USER";
        public static final String DOCTOR = "ROLE_DOCTOR";
        public static final String ADMIN = "ROLE_ADMIN";
    }

    private final String key;
    private final String title;
}
