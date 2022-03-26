package com.example.medicalProject.domain.entity.patientInfo;

import com.example.medicalProject.domain.entity.user.User;
import com.example.medicalProject.web.dto.PatientInfoListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PatientInfoServiceImpl implements PatientInfoService {
    private final PatientInfoRepository patientInfoRepository;

    @Override
    public List<PatientInfoListResponseDto> getPatientInfos(User user) {
        return patientInfoRepository.findAllByUser(user).stream()
                .map(PatientInfoListResponseDto::new).collect(Collectors.toList());
    }
}
