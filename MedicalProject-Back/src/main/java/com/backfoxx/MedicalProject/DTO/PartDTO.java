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
    private long day;
    private String part;
    private String symptom;
    private int intensity;

    //PartEntity를 DTO로 변환
    public PartDTO(final PartEntity entity) {
        this.id = entity.getId();
        this.day = entity.getDay();
        this.part = entity.getPart();
        this.symptom = entity.getSymptom();;
        this.intensity = entity.getIntensity();
    }

    public static PartEntity toEntity(final PartDTO dto) {
        return PartEntity.builder()
                .id(dto.getId())
                .day(dto.getDay())
                .part(dto.getPart())
                .symptom(dto.getSymptom())
                .intensity(dto.getIntensity())
                .build();
    }
}
