
package com.backfoxx.MedicalProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Part")
public class PartEntity {
    @Id
    private String day;
    private String userId;
    private String part; //아픈 부위
    private String symptom; //증상
    private int intensity; //강도
}
