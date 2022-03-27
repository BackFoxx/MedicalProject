package com.example.medicalProject.domain.entity.patientInfo;

import com.example.medicalProject.domain.entity.medicineInfo.MedicineInfo;
import com.example.medicalProject.domain.entity.user.Status;
import com.example.medicalProject.domain.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "PatientInfoJsonIdentityInfoId")
public class PatientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    private String name;
    private int degree;
    private String description;

    @OneToMany(mappedBy = "patientInfoId", cascade = CascadeType.ALL)
    private List<MedicineInfo> medicineInfos = new ArrayList<MedicineInfo>();

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private Timestamp createDate;

    public void addUser(User user) {
        if (this.user != null) {
            this.user.getPatientInfos().remove(this);
        }
        this.user = user;
        user.getPatientInfos().add(this);
    }
}
