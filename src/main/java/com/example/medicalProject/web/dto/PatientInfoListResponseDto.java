package com.example.medicalProject.web.dto;

import com.example.medicalProject.domain.entity.medicineInfo.MedicineInfo;
import com.example.medicalProject.domain.entity.patientInfo.PatientInfo;
import com.example.medicalProject.domain.entity.user.Status;
import com.example.medicalProject.domain.entity.user.User;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PatientInfoListResponseDto {
    private Long id;
    private User user;
    private String name;
    private int degree;
    private String description;
    private List<MedicineInfo> medicineInfos = new ArrayList<MedicineInfo>();
    private Status status;
    private Date createDate;

    @Builder
    public PatientInfoListResponseDto(PatientInfo patientInfo) {
        this.id = patientInfo.getId();
        this.user = patientInfo.getUser();
        this.name = patientInfo.getName();
        this.degree = patientInfo.getDegree();
        this.description = patientInfo.getDescription();
        this.medicineInfos = patientInfo.getMedicineInfos();
        this.status = patientInfo.getStatus();
        this.createDate = patientInfo.getCreateDate();
    }
}
