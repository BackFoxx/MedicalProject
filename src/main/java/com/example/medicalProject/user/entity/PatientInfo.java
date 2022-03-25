package com.example.medicalProject.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
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

    @OneToMany(mappedBy = "patientInfoId")
    private List<MedicineInfo> medicineInfos = new ArrayList<MedicineInfo>();

    @Enumerated(EnumType.STRING)
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createDate;

    public void setUser(User user) {
        if (this.user != null) {
            this.user.getPatientInfos().remove(this);
        }
        this.user = user;
        user.getPatientInfos().add(this);
    }
}
