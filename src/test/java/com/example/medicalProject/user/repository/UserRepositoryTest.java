package com.example.medicalProject.user.repository;

import com.example.medicalProject.user.entity.PatientInfo;
import com.example.medicalProject.user.entity.Status;
import com.example.medicalProject.user.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientInfoRepository patientInfoRepository;

    @Test
    void User_생성하기() throws Exception {
        //given
        User user = User.builder()
                .username("Tester1")
                .email("tester1@gmail.com")
                .password("tester1234")
                .build();
        //when
        userRepository.save(user);
        //then
        Optional<User> foundUser = userRepository.findById(user.getId());
        assertThat(foundUser).isNotEmpty();
        assertThat(foundUser.get().getEmail()).isEqualTo("tester1@gmail.com");
    }

    @Test
    void PatientInfo_생성하기() throws Exception {
        //given
        User user = User.builder()
                .username("Tester1")
                .email("tester1@gmail.com")
                .password("tester1234")
                .build();
        PatientInfo patientInfo = PatientInfo.builder()
                .status(Status.BATTELING)
                .user(user)
                .build();


        //when

        userRepository.save(user);
        patientInfoRepository.save(patientInfo);

        //then
        Optional<PatientInfo> found = patientInfoRepository.findById(patientInfo.getId());
        assertThat(found.get().getUser().getEmail()).isEqualTo(user.getEmail());
        System.out.println("patientInfo = " + patientInfo.getCreateDate());
    }
}