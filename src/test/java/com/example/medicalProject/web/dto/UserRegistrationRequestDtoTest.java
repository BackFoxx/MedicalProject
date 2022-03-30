package com.example.medicalProject.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import java.util.Set;

import static org.junit.Assert.*;

public class UserRegistrationRequestDtoTest {
    @Test
    public void RegistrationRequestDto유효성검사() {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        UserRegistrationRequestDto dto = new UserRegistrationRequestDto();
        dto.setEmail("jojjang@gmail.com");
        dto.setUsername("");
        dto.setPassword("sam");
        dto.setRoleName("admin");

        Set<ConstraintViolation<UserRegistrationRequestDto>> validate = validator.validate(dto);

        Assertions.assertThat(validate.iterator().next().getMessage()).isEqualTo("유저네임은 필수 입력값입니다.");
    }

}