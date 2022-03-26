package com.example.medicalProject.user.repository;

import com.example.medicalProject.domain.entity.patientInfo.PatientInfo;
import com.example.medicalProject.domain.entity.user.User;
import com.example.medicalProject.domain.entity.patientInfo.PatientInfoRepository;
import com.example.medicalProject.domain.entity.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        User user = new User();

        PatientInfo patientInfo1 = new PatientInfo();
//        patientInfo1.setDescription("아파요");
        PatientInfo patientInfo2 = new PatientInfo();
//        patientInfo2.setDescription("안 아파요");

        patientInfo1.addUser(user);
        patientInfo2.addUser(user);

        //when

        userRepository.save(user);
        patientInfoRepository.save(patientInfo1);
        patientInfoRepository.save(patientInfo2);

        //then
        Optional<PatientInfo> found1 = patientInfoRepository.findById(patientInfo1.getId());
        if (found1.isPresent()) {
            assertThat(found1.get().getDescription()).isEqualTo("아파요");
        }

        Optional<PatientInfo> found2 = patientInfoRepository.findById(patientInfo2.getId());
        if (found2.isPresent()) {
            assertThat(found2.get().getDescription()).isEqualTo("안 아파요");
        }
    }
}