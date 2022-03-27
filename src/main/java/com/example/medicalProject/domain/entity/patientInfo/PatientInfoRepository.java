package com.example.medicalProject.domain.entity.patientInfo;

import com.example.medicalProject.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientInfoRepository extends JpaRepository<PatientInfo, Long> {
    public List<PatientInfo> findAllByUserId(Long userId);
}
