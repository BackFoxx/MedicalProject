package com.example.medicalProject.domain.controller;

import com.example.medicalProject.config.auth.PrincipalDetails;
import com.example.medicalProject.domain.entity.patientInfo.PatientInfoService;
import com.example.medicalProject.web.dto.PatientInfoListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PatientListController {
    private final PatientInfoService patientInfoService;

    @GetMapping("/patientList")
    public String patientInfo(@AuthenticationPrincipal PrincipalDetails userDetails, Model model) {
        try {
            List<PatientInfoListResponseDto> patientInfos = patientInfoService.getPatientInfos(userDetails.getId());
            model.addAttribute("patientInfos", patientInfos);
            return "patientList";
        } catch (NullPointerException e) {
            // 로그인되지 않은 상태로 접속하여 생기는 예외
            model.addAttribute("error", "로그인 후 이용해주세요!!");
            return "patientList";
        }
    }
}
