//���� ���� �����͸� ���� ��ƼƼ
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
    private String part; //������ �ִ� ��ü����
    private String symptom; //����
    private int intensity; //����
}
