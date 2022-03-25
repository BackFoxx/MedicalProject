package com.example.medicalProject.user.repository;

import com.example.medicalProject.user.entity.PatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientInfoRepository extends JpaRepository<PatientInfo, Long> {
}
