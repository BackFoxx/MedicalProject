package com.example.medicalProject.domain.entity.medicineInfo;

import com.example.medicalProject.domain.entity.patientInfo.PatientInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MedicineInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PATIENT_INFO_ID")
    private PatientInfo patientInfoId;

    private String name;
    private int amount;

    @CreationTimestamp
    private Timestamp prescriptionDate;

    @CreationTimestamp
    private Timestamp createDate;

    public void setPatientInfoId(PatientInfo patientInfoId) {
        if (this.patientInfoId != null) {
            this.patientInfoId.getMedicineInfos().remove(this);
        }
        this.patientInfoId = patientInfoId;
        patientInfoId.getMedicineInfos().add(this);
    }
}
