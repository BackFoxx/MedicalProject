//PartEntity의 DTO버전
package com.backfoxx.MedicalProject.DTO;

import com.backfoxx.MedicalProject.model.PartEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PartDTO {
    private String id;
    private String part;
    private String symptom;
    private int intensity;

    //PartEntity를 DTO로 변환
    public PartDTO(final PartEntity entity) {
        this.id = entity.getId();
        this.part = entity.getPart();
        this.symptom = entity.getSymptom();;
        this.intensity = entity.getIntensity();
    }
}
