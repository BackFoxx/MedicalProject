package com.example.medicalProject.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date prescriptionDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public void setPatientInfoId(PatientInfo patientInfoId) {
        if (this.patientInfoId != null) {
            this.patientInfoId.getMedicineInfos().remove(this);
        }
        this.patientInfoId = patientInfoId;
        patientInfoId.getMedicineInfos().add(this);
    }
}
