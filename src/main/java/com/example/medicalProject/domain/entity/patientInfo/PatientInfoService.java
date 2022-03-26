package com.example.medicalProject.domain.entity.patientInfo;

import com.example.medicalProject.domain.entity.patientInfo.PatientInfo;
import com.example.medicalProject.domain.entity.user.User;
import com.example.medicalProject.web.dto.PatientInfoListResponseDto;

import java.util.List;

public interface PatientInfoService {
    List<PatientInfoListResponseDto> getPatientInfos(User user);
}
