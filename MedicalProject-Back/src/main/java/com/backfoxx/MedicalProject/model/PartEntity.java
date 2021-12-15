//증상에 대한 데이터를 담은 엔티티
package com.backfoxx.MedicalProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartEntity {
    private String part; //증상이 있는 신체부위
    private String symptom; //증상
    private int intensity; //강도
}
