//PartEntity�� DTO���� Ŭ����
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
    private String part;
    private String symptom;
    private int intensity;

    //PartEntity�� ��ҵ��� DTO�� �ٲٴ� �۾�
    public PartDTO(final PartEntity entity) {
        this.part = entity.getPart();
        this.symptom = entity.getSymptom();;
        this.intensity = entity.getIntensity();
    }
}
